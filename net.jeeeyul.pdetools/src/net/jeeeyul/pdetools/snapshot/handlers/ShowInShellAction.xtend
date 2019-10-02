package net.jeeeyul.pdetools.snapshot.handlers

import java.io.File
import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
import net.jeeeyul.pdetools.shared.LaunchCommand
import net.jeeeyul.pdetools.snapshot.SnapshotAction
import org.eclipse.core.runtime.Platform

class ShowInShellAction extends SnapshotAction {
	new(SnapshotRepository repository) {
		super(repository)
	}
	
	override getText() {
		switch (Platform.OS) {
			case Platform.OS_MACOSX: 	"Reveal in Finder"
			case Platform.OS_WIN32:		"Show in Explorer"
			default:					"Show in Shell"
		}
	}

	override run() {
		var command = createCommand()
		if(command !== null){
			command.execute()
		}
	}
	
	override update() {
		setEnabled(selection !== null && selection.size > 0)
	}

	private def SnapshotEntry getFirstSelectedEntry() {
		this.selection.head
	}

	private def LaunchCommand createCommand() {
		switch (Platform.OS) {
			case Platform.OS_MACOSX: {
				new LaunchCommand=>[
					commands += "osascript"
					commands += "-e"
					commands += '''tell app "Finder" to activate reveal Posix file "«firstSelectedEntry.absoulteVisibleFilePath»"'''.toString
				]
			}
			
			case Platform.OS_WIN32: {
				new LaunchCommand => [
					envMap.put("pde_tools_target_file", '''/select,"«firstSelectedEntry.absoulteVisibleFilePath»"'''.toString)
					
					commands += "cmd"
					commands += "/c"
					commands += "C:/windows/explorer"
					commands += "%pde_tools_target_file%"
				]
			}
			
			case Platform.OS_LINUX : {
				new LaunchCommand() => [
					var folder = new File(firstSelectedEntry.absoulteVisibleFilePath)
					if(!folder.directory){
						folder = folder.parentFile
					}
					
					commands += "/bin/bash"
					commands += "-c"
					commands += '''xdg-open "«folder.absolutePath»"'''.toString
				]
			}
			
			default: null
		}
	}
}