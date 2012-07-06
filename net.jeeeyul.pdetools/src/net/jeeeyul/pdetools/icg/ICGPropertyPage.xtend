package net.jeeeyul.pdetools.icg

import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.core.resources.IProject
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.search.SearchEngine
import org.eclipse.jdt.ui.JavaUI
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.dialogs.ElementListSelectionDialog
import org.eclipse.ui.dialogs.PropertyPage
import org.eclipse.ui.model.WorkbenchLabelProvider
import org.eclipse.jdt.core.IPackageFragment

class ICGPropertyPage extends PropertyPage {
	extension SWTExtensions = new SWTExtensions()
	
	ICGConfiguration _config;
	Text monitoringFolderField;
	Text generateSrcFolderField;
	Text generateSrcPackageField;
	
	override protected createContents(Composite parent) {
		parent.Composite[
			layout = GridLayout[numColumns = 3]
			
			Label[text="Monitoring Folder:"]
			
			monitoringFolderField = TextField[
				layoutData = FILL_HORIZONTAL
			]
			
			PushButton[
				text = "Browse"
				onClick = [browserMonitoringFolder()]
			]
			
			Group[
				text = "Generation"
				layout = GridLayout[numColumns = 3]
				layoutData = FILL_HORIZONTAL[horizontalSpan = 3]
				
				Label[text="Source Folder:"]
				generateSrcFolderField = TextField[
					layoutData = FILL_HORIZONTAL
				]
				PushButton[
					text = "Browse"
					onClick = [browseSrcFolder()]
				]
				
				Label[text="Package:"]
				generateSrcPackageField = TextField[
					layoutData = FILL_HORIZONTAL
				]
				PushButton[
					text = "Browse"
					onClick = [browsePackage()]
				]
				
				Checkbox[
					layoutData = GridData[horizontalSpan = 3]
					text = "Mark derived"
				]
			]
		]
	}
	def void browsePackage() {
		var srcFolders = javaProject.allPackageFragmentRoots.filter[
			try{
				it.kind == IPackageFragmentRoot::K_SOURCE
			}catch(Exception e){
				false;
			}
		];
		
		var scope = SearchEngine::createJavaSearchScope(srcFolders as IJavaElement[])
		var dialog = JavaUI::createPackageDialog(control.shell, PlatformUI::workbench.progressService, scope, false, true, null);
			
		if(dialog.open() == IDialogConstants::OK_ID){
			var fragment = dialog.result.get(0) as IPackageFragment
			generateSrcPackageField.text = fragment.elementName
		}
	}

	def create  JavaCore::create(project) javaProject(){
	}
	
	def void browseSrcFolder() {
		var srcFolders = javaProject.allPackageFragmentRoots.filter[
			try{
				it.kind == IPackageFragmentRoot::K_SOURCE
			}catch(Exception e){
				false;
			}
		];
		
		var dialog = new ElementListSelectionDialog(control.shell, WorkbenchLabelProvider::decoratingWorkbenchLabelProvider)
		dialog.setElements(srcFolders)
		dialog.setMessage("Select source folder to generate");
		dialog.setTitle("Image Constants Generator");

		if(dialog.open() == IDialogConstants::OK_ID){
			var srcFolder = dialog.result.get(0) as IPackageFragmentRoot
			generateSrcFolderField.text =  srcFolder.resource.projectRelativePath.toPortableString
		}
	}

	
	def browserMonitoringFolder(){
	}
	
	def  config(){
		if(_config == null){
			_config = new ICGConfiguration(project)
		}
		return _config
	}
	
	def IProject getProject(){
		if(element instanceof IProject){
			return element as IProject;
		}else{
			return element.getAdapter(typeof(IProject)) as IProject
		}
	}
}