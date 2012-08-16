package net.jeeeyul.pdetools.icg.ui

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.shared.SWTExtensions
import net.jeeeyul.pdetools.shared.SharedImages
import net.jeeeyul.pdetools.shared.SimpleViewerFilter
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.Path
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IPackageFragment
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.search.SearchEngine
import org.eclipse.jdt.ui.JavaUI
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.dialogs.ElementListSelectionDialog
import org.eclipse.ui.dialogs.PropertyPage
import org.eclipse.ui.model.WorkbenchLabelProvider

class ICGPropertyPage extends PropertyPage {
	public static  val ID = "net.jeeeyul.pdetools.icg.propertyPage"
	extension SWTExtensions = new SWTExtensions()
	ICGConfiguration _config
	Text monitoringFolderField
	Text imageFileExtensionsField
	Text generateSrcFolderField
	Text generateSrcPackageField
	Text generateClassNameField
	Button markDerivedField
	Button generatePreviewField
	Composite contents

	override protected createContents(Composite parent) {
		schedule[refresh()]
		contents = parent.Composite[
			layout = GridLayout
			Group[
				text = "Monitoring"
				layout = GridLayout[ numColumns = 3 ]
				layoutData = FILL_HORIZONTAL
				Label[ text="Monitoring Folder:" ]
				monitoringFolderField = TextField[
					layoutData = FILL_HORIZONTAL
				]
				PushButton[
					text = "Browse"
					onClick = [browserMonitoringFolder()]
				]
				Label[ text = "Image File Extensions:" ]
				imageFileExtensionsField = TextField[
					layoutData = FILL_HORIZONTAL[ horizontalSpan = 2 ]
				]
				
				Label[
					layoutData = FILL_HORIZONTAL[
						horizontalSpan = 3
						horizontalAlignment = SWT::RIGHT	
					]
					text = "comma(,) separated file extensions"
				]
			]
			Group[
				text = "Generation"
				layout = GridLayout[ numColumns = 3 ]
				layoutData = FILL_HORIZONTAL
				Label[ text="Source Folder:" ]
				generateSrcFolderField = TextField[
					layoutData = FILL_HORIZONTAL
				]
				PushButton[
					text = "Browse"
					onClick = [browseSrcFolder()]
				]
				Label[ text="Package:" ]
				generateSrcPackageField = TextField[
					layoutData = FILL_HORIZONTAL
				]
				PushButton[
					text = "Browse"
					onClick = [browsePackage()]
				]
				Label[ text="Class Name:" ]
				generateClassNameField = TextField[
					layoutData = FILL_HORIZONTAL[
						horizontalSpan = 2
					]
				]
				generatePreviewField = Checkbox[
					layoutData = GridData[ horizontalSpan = 3 ]
					text = "Generate Image Preview in Javadoc"
				]
				markDerivedField = Checkbox[
					layoutData = GridData[ horizontalSpan = 3 ]
					text = "Mark derived"
				]
			]
		]
		for(e : contents.allContents.filter(typeof(Text)).toList){
			var gridData = e.layoutData as GridData
			gridData.horizontalIndent = 16
			var deco = new ControlDecoration(e, SWT::LEFT)
			deco.setImage(SharedImages::getImage(SharedImages::ERROR))
			deco.hide()
			e.setData("decoration", deco)
			e.onModified = [
				validate()
			]
		}
		return contents
	}

	def getDecoration(Text text){
		return text.getData("decoration") as ControlDecoration
	}

	def private void refresh(){
		if(config.monitoringFolder != null) {
			monitoringFolderField.text = config.monitoringFolder.projectRelativePath.toPortableString
		} else {
			monitoringFolderField.text = ""
		}
		if(config.generateSrcFolder != null) {
			generateSrcFolderField.text = config.generateSrcFolder.projectRelativePath.toPortableString
		} else {
			generateSrcFolderField.text = ""
		}
		generateSrcPackageField.text = config.generatePackageName.nullSafeString
		generateClassNameField.text = config.generateClassName.nullSafeString
		generatePreviewField.selection = config.generateImagePreview
		markDerivedField.selection = config.markDerived
		if(config.imageFileExtensions != null) {
			imageFileExtensionsField.text = config.imageFileExtensions.join(", ")
		} else {
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
		if(dialog.open() == IDialogConstants::OK_ID) {
			var fragment = dialog.result.get(0) as IPackageFragment
			generateSrcPackageField.text = fragment.elementName
		}
	}

	def private create  JavaCore::create(project) javaProject(){
	}

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
		if(dialog.open() == IDialogConstants::OK_ID) {
			var srcFolder = dialog.result.get(0) as IPackageFragmentRoot
			generateSrcFolderField.text =  srcFolder.resource.projectRelativePath.toPortableString
		}
	}

	def private browserMonitoringFolder(){
		var dialog = new FolderSelectionDialog(control.shell)
		dialog.addFilter(new SimpleViewerFilter[
			it instanceof IContainer
		]);
		dialog.setMessage("Choose a folder to monitor image files:")
		dialog.setTitle("Image Constants Generator");
		dialog.targetProject = config.project
		if(dialog.open() == IDialogConstants::OK_ID) {
			monitoringFolderField.text = (dialog.result.get(0) as IFolder).projectRelativePath.toPortableString
		}
	}

	def private config(){
		if(_config == null) {
			_config = new ICGConfiguration(project)
		}
		return _config
	}

	def private IProject getProject(){
		if(element instanceof IProject) {
			return element as IProject;
		} else {
			return element.getAdapter(typeof(IProject)) as IProject
		}
	}

	def nullSafeString(String string){
		if(string == null) {
			""
		} else {
			string
		}
	}

	override performOk() {
		if(!monitoringFolderField.text.empty) {
			config.monitoringFolder = project.getFolder(new Path(monitoringFolderField.text.trim))
		} else {
			config.monitoringFolder = null
		}
		if(!generateSrcFolderField.text.empty) {
			config.generateSrcFolder = project.getFolder(new Path(generateSrcFolderField.text.trim))
		} else {
			config.generateSrcFolder = null
		}
		config.imageFileExtensions = imageFileExtensionsField.text.trim.split("[ ,]+")
		config.generateClassName = generateClassNameField.text.trim
		config.generatePackageName = generateSrcPackageField.text.trim
		config.markDerived = markDerivedField.selection
		config.generateImagePreview = generatePreviewField.selection
		config.save()
		super.performOk()
	}

	override protected performDefaults() {
		
		refresh();
	}
	
	def showError(Text text, String message){
		var deco = text.decoration
		deco.descriptionText = message
		if(message != null){
			deco.show()
		}else{
			deco.hide()
		}
	}

	def clearError(Text text){
		text.showError(null)
	}

	def validate(){
		contents.allContents.filter(typeof(Text)).forEach[it.clearError]
		
		var folderPath = monitoringFolderField.text.trim
	
		if(folderPath.empty){
			monitoringFolderField.showError("Image folder must be setted.")
		}else{
			var folder = project.getFolder(new Path(folderPath))
			if(!folder.exists) {
				monitoringFolderField.showError("Non-existing Folder")
			}
		}
		
		var fileExtensions = imageFileExtensionsField.text.trim
		if(fileExtensions.empty){
			imageFileExtensionsField.showError("Image file extensions are must be setted.")
		}
		
		var srcFolder = generateSrcFolderField.text.trim
		if(srcFolder.empty){
			generateSrcFolderField.showError("Generated Source Folder must be setted.")
		}
		
		var packageName = generateSrcPackageField.text.trim
		if(packageName.empty){
			generateSrcPackageField.showError("Generated Package Name must be setted.")
		}else if(!packageName.matches("[a-zA-Z_][a-zA-Z0-9_]*(\\.[a-zA-Z_][a-zA-Z0-9_]*)*")){
			generateSrcPackageField.showError("Invalid pacakge name.")
		}
		
		var className = generateClassNameField.text.trim
		if(className.empty){
			generateClassNameField.showError("Generated Class Name must be setted.")
		}else if(!className.matches("[a-zA-Z_][a-zA-Z0-9_]*")){
			generateClassNameField.showError("Invalid class name.")
		}
	}
}