package net.jeeeyul.pdetools.icg.ui

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
import org.eclipse.swt.widgets.Button
import org.eclipse.core.runtime.Path
import net.jeeeyul.pdetools.icg.ICGConfiguration

class ICGPropertyPage extends PropertyPage {
	public static  val ID = "net.jeeeyul.pdetools.icg.propertyPage"
	extension SWTExtensions = new SWTExtensions()
	
	ICGConfiguration _config;
	Text monitoringFolderField;
	Text imageFileExtensionsField;
	Text generateSrcFolderField;
	Text generateSrcPackageField;
	Button markDerivedField;
	
	override protected createContents(Composite parent) {
		schedule[refresh()];
		parent.Composite[
			layout = GridLayout
			
			Group[
				text = "Monitoring"
				layout = GridLayout[numColumns = 3]
				layoutData = FILL_HORIZONTAL
				
				Label[text="Monitoring Folder:"]
			
				monitoringFolderField = TextField[
					layoutData = FILL_HORIZONTAL
				]
				
				PushButton[
					text = "Browse"
					onClick = [browserMonitoringFolder()]
				]
				
				Label[text = "Image File Extensions:"]
				imageFileExtensionsField = TextField[
					layoutData = FILL_HORIZONTAL[horizontalSpan = 2]
				]
			]
			
			Group[
				text = "Generation"
				layout = GridLayout[numColumns = 3]
				layoutData = FILL_HORIZONTAL
				
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
				
				markDerivedField = Checkbox[
					layoutData = GridData[horizontalSpan = 3]
					text = "Mark derived"
				]
			]
		]
	}
	
	def private void refresh(){
		if(config.monitoringFolder != null){
			monitoringFolderField.text = config.monitoringFolder.projectRelativePath.toPortableString
		}
		else{
			monitoringFolderField.text = ""
		}
		
		if(config.generateSrcFolder != null){
			generateSrcFolderField.text = config.generateSrcFolder.projectRelativePath.toPortableString
		}else{
			generateSrcFolderField.text = ""
		}
		
		generateSrcPackageField.text = config.generatePackageName.nullSafeString
		markDerivedField.selection = config.markDerived
		
		if(config.imageFileExtensions != null){
			imageFileExtensionsField.text = config.imageFileExtensions.join(", ")
		}else{
			imageFileExtensionsField.text = ""
		}
		
	}
	
	def private void browsePackage() {
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

	def private create  JavaCore::create(project) javaProject(){}
	
	def private void  browseSrcFolder() {
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

	
	def private browserMonitoringFolder(){
	}
	
	def  private config(){
		if(_config == null){
			_config = new ICGConfiguration(project)
		}
		return _config
	}
	
	def private IProject getProject(){
		if(element instanceof IProject){
			return element as IProject;
		}else{
			return element.getAdapter(typeof(IProject)) as IProject
		}
	}
	
	def nullSafeString(String string){
		if(string == null){
			""
		}else{
			string
		}
	}
	
	override performOk() {
		if(!monitoringFolderField.text.empty){
			config.monitoringFolder = project.getFolder(new Path(monitoringFolderField.text.trim));	
		}else{
			config.monitoringFolder = null
		}
		if(!generateSrcFolderField.text.empty){
			config.generateSrcFolder = project.getFolder(new Path(generateSrcFolderField.text.trim));
		}else{
			config.generateSrcFolder = null
		}
		
		config.imageFileExtensions = imageFileExtensionsField.text.trim.split("[ ,]+"); 
		
		config.generatePackageName = generateSrcPackageField.text.trim
		config.markDerived = markDerivedField.selection
		config.save()
		super.performOk()
	}
	
	override protected performDefaults() {
		refresh();
	}
	
}