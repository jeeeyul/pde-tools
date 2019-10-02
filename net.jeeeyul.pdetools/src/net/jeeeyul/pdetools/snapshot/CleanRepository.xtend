package net.jeeeyul.pdetools.snapshot

import org.eclipse.core.runtime.Path
import java.util.ArrayList
import java.io.File
import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry
import net.jeeeyul.pdetools.Debug

class CleanRepository {
	def void run(){
		var repo = SnapshotCore::repository
		var repoPath = new Path(repo.eResource.URI.toFileString())
		var repoFolderPath = repoPath.removeLastSegments(1)

		// Repository Location
		var repoFolder = repoFolderPath.toFile()
		
		// Prepare file list to remove
		var files = repoFolder.listFiles.filter[!it.directory].toList
		var filesToDelete = new ArrayList<File>(files)
		
		filesToDelete.remove(repoPath.toFile)
		
		for(e : repo.eAllContents.filter(typeof(SnapshotEntry)).toList){
			if(e.originalFile !== null){
				filesToDelete.remove(repoFolderPath.append(e.originalFile).toFile)
			}
			
			if(e.renderedFile !== null){
				filesToDelete.remove(repoFolderPath.append(e.renderedFile).toFile)
			}
		}
		
		for(f : filesToDelete){
			try{
				f.delete()
			}catch(Exception e){
				f.deleteOnExit()
			}
		}
		
		Debug::println(filesToDelete.size + " files were cleaned from snapshot repository.")
	}
}