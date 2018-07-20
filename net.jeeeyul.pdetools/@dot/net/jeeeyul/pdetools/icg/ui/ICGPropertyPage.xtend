package net.jeeeyul.pdetools.icg.ui

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.shared.SharedImages
import net.jeeeyul.pdetools.shared.SimpleViewerFilter
import net.jeeeyul.swtend.SWTExtensions
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
import org.eclipse.ui.progress.UIJob

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
	
	Button standardButton
	Button graphitiButton
	
	UIJob validateJob = newUIJob[
		if(control == null || control.isDisposed()){
			return;
		}
		doValidate()
	]
	
	def void doValidate() {
		(control as Composite).allContent.filter(typeof(Text)).forEach[
			it.errorMessage = null
		]
		
		var folderPath = monitoringFolderField.text.trim
		if(folderPath.empty){
			monitoringFolderField.errorMessage = ("Image folder must be setted.")
		}else{
			var folder = project.getFolder(new Path(folderPath))
			if(!folder.exists) {
				monitoringFolderField.errorMessage = ("Non-existing Folder")
			}
		}
		
		var fileExtensions = imageFileExtensionsField.text.trim
		if(fileExtensions.empty){
			imageFileExtensionsField.errorMessage = ("Image file extensions are must be setted.")
		}
		
		var srcFolder = generateSrcFolderField.text.trim
		if(srcFolder.empty){
			generateSrcFolderField.errorMessage = ("Generated Source Folder must be setted.")
		}
		
		var packageName = generateSrcPackageField.text.trim
		if(packageName.empty){
			generateSrcPackageField.errorMessage = ("Generated Package Name must be setted.")
		}else if(!packageName.matches("[a-zA-Z_][a-zA-Z0-9_]*(\\.[a-zA-Z_][a-zA-Z0-9_]*)*")){
			generateSrcPackageField.errorMessage = ("Invalid pacakge name.")
		}
		
		var className = generateClassNameField.text.trim
		if(className.empty){
			generateClassNameField.errorMessage = ("Generated Class Name must be setted.")
		}else if(!className.matches("[a-zA-Z_][a-zA-Z0-9_]*")){
			generateClassNameField.errorMessage = ("Invalid class name.")
		}
		
		(control as Composite).allContent.filter(typeof(Text)).forEach[
			if(it.errorMessage != null){
				it.decoration.descriptionText = it.errorMessage
				it.decoration.show()
			}else{
				it.decoration.hide()
			}
		]
	}

	override protected createContents(Composite parent) {
		schedule[refresh()]
		var container = parent.newComposite[
			layout = newGridLayout
			newGroup[
				text = "Monitoring"
				layout = newGridLayout[ numColumns = 3 ]
				layoutData = FILL_HORIZONTAL
				newLabel[ text="Monitoring Folder:" ]
				monitoringFolderField = newTextField[
					layoutData = FILL_HORIZONTAL
				]
				newPushButton[
					text = "Browse"
					onClick = [browserMonitoringFolder()]
				]
				newLabel[ text = "Image File Extensions:" ]
				imageFileExtensionsField = newTextField[
					layoutData = FILL_HORIZONTAL[ horizontalSpan = 2 ]
				]
				
				newLabel[
					layoutData = FILL_HORIZONTAL[
						horizontalSpan = 3
						horizontalAlignment = SWT::RIGHT	
					]
					text = "comma(,) separated file extensions"
				]
			]
			newGroup[
				text = "Generation"
				layout = newGridLayout[ numColumns = 3 ]
				layoutData = FILL_HORIZONTAL
				
				newLabel[
					text = "Type:"
				]
				
				newComposite[
					layoutData = FILL_HORIZONTAL[
						horizontalSpan = 2
						horizontalIndent = 16
					]
					layout = newGridLayout[
						marginHeight = 0
						marginWidth = 0
						numColumns = 2
					]
					
					standardButton = it.newRadioButton[
						text = "Standard"
					]
					
					graphitiButton = it.newRadioButton[
						text = "Graphiti"
					]
				]
				
				newLabel[ text="Source Folder:" ]
				generateSrcFolderField = newTextField[
					layoutData = FILL_HORIZONTAL
				]
				newPushButton[
					text = "Browse"
					onClick = [browseSrcFolder()]
				]
				newLabel[ text="Package:" ]
				generateSrcPackageField = newTextField[
					layoutData = FILL_HORIZONTAL
				]
				newPushButton[
					text = "Browse"
					onClick = [browsePackage()]
				]
				newLabel[ text="Class Name:" ]
				generateClassNameField = newTextField[
					layoutData = FILL_HORIZONTAL[
						horizontalSpan = 2
					]
				]
				generatePreviewField = newCheckbox[
					layoutData = newGridData[ horizontalSpan = 3 ]
					text = "Generate Image Preview in Javadoc"
				]
				markDerivedField = newCheckbox[
					layoutData = newGridData[ horizontalSpan = 3 ]
					text = "Mark derived"
				]
			]
		]
		for(e : container.allContent.filter(typeof(Text)).toList){
			var gridData = e.layoutData as GridData
			gridData.horizontalIndent = 16
			var deco = new ControlDecoration(e, SWT::LEFT)
			deco.hide()
			deco.setImage(SharedImages::getImage(SharedImages::ERROR))
			e.setData("decoration", deco)
			e.onModified = [
				validate()
			]
		}
		return container
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
		
		standardButton.selection = config.generateType == ICGConfiguration::GENERATE_TYPE_STANDARD
		graphitiButton.selection = config.generateType == ICGConfiguration::GENERATE_TYPE_GRAPHITI
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
				it.kind == IPackageFragmentRoot::K_SOURCE && it.resource.project == project
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
		var folderPath = monitoringFolderField.text.trim
		if(!folderPath.empty){
			dialog.setInitialSelection(project.getFolder(new Path(folderPath)))
		}
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
		
		if(standardButton.selection){
			config.generateType = ICGConfiguration::GENERATE_TYPE_STANDARD
		}else{
			config.generateType = ICGConfiguration::GENERATE_TYPE_GRAPHITI
		}
		
		config.save()
		super.performOk()
	}

	override protected performDefaults() {
		refresh();
	}
	
	def setErrorMessage(Text text, String errorMessage){
		text.setData("error-message", errorMessage)
	}
	
	def String getErrorMessage(Text text){
		return text.getData("error-message") as String
	}

	def validate(){
		validateJob.schedule()
	}
}