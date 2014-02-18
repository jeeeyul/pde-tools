package net.jeeeyul.pdetools.shared

import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.resources.IFile

class ResourceExtensions {
	def dispatch void ensureExist(IFolder folder) {
		if(folder.exists) {
			return;
		}
		if(!folder.parent.exists) {
			folder.parent.ensureExist()
		}
		folder.create(true, true, new NullProgressMonitor())
	}

	def dispatch void ensureExist(IContainer container) {
	}

	def dispatch void ensureExist(IProject project) {
		if(!project.exists) {
			project.create(new NullProgressMonitor())
		} else
			if(!project.open) {
				project.open(new NullProgressMonitor())
			}
	}

	def getContentAsBytes(IFile file) {
		return ResourceExtensionHelper::load(file)
	}
}