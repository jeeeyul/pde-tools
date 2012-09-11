package net.jeeeyul.pdetools.snapshot

import org.eclipse.core.runtime.Path

class CleanRepository {
	def run(){
		var repo = SnapshotCore::repository
		var repoPath = new Path(repo.eResource.URI.toPlatformString(false))
		var repoFolderPath = repoPath.removeLastSegments(1)
		
		var repoFolder = repoFolderPath.toFile()
		
		var files = repoFolder.listFiles.filter[!it.directory].toList
		
	}
}