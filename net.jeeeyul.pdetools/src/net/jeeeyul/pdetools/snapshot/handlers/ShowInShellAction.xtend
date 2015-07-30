package net.jeeeyul.pdetools.snapshot.handlers

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
		if(command != null){
			command.execute()
		}
	}
	
	override update() {
		setEnabled(selection != null && selection.size > 0)
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
			
			default: null
		}
	}
}