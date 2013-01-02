/**
 */
package net.jeeeyul.pdetools.model.pdetools.util;

import net.jeeeyul.pdetools.model.pdetools.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage
 * @generated
 */
public class PdetoolsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PdetoolsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdetoolsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PdetoolsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PdetoolsSwitch<Adapter> modelSwitch = new PdetoolsSwitch<Adapter>() {
		@Override
		public Adapter caseClipboardElement(ClipboardElement object) {
			return createClipboardElementAdapter();
		}

		@Override
		public Adapter caseClipHistory(ClipHistory object) {
			return createClipHistoryAdapter();
		}

		@Override
		public Adapter caseClipboardEntry(ClipboardEntry object) {
			return createClipboardEntryAdapter();
		}

		@Override
		public Adapter caseTextRange(TextRange object) {
			return createTextRangeAdapter();
		}

		@Override
		public Adapter caseJavaInfo(JavaInfo object) {
			return createJavaInfoAdapter();
		}

		@Override
		public Adapter caseFieldNameOwner(FieldNameOwner object) {
			return createFieldNameOwnerAdapter();
		}

		@Override
		public Adapter casePalette(Palette object) {
			return createPaletteAdapter();
		}

		@Override
		public Adapter caseImageFile(ImageFile object) {
			return createImageFileAdapter();
		}

		@Override
		public Adapter caseSnapshotRepository(SnapshotRepository object) {
			return createSnapshotRepositoryAdapter();
		}

		@Override
		public Adapter caseSnapshotGroup(SnapshotGroup object) {
			return createSnapshotGroupAdapter();
		}

		@Override
		public Adapter caseSnapshotEntry(SnapshotEntry object) {
			return createSnapshotEntryAdapter();
		}

		@Override
		public Adapter caseShellInfo(ShellInfo object) {
			return createShellInfoAdapter();
		}

		@Override
		public Adapter caseCommandHistory(CommandHistory object) {
			return createCommandHistoryAdapter();
		}

		@Override
		public Adapter caseCommandEvent(CommandEvent object) {
			return createCommandEventAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardElement <em>Clipboard Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardElement
	 * @generated
	 */
	public Adapter createClipboardElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.ClipHistory <em>Clip History</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipHistory
	 * @generated
	 */
	public Adapter createClipHistoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry <em>Clipboard Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry
	 * @generated
	 */
	public Adapter createClipboardEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.TextRange <em>Text Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.TextRange
	 * @generated
	 */
	public Adapter createTextRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.JavaInfo <em>Java Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.JavaInfo
	 * @generated
	 */
	public Adapter createJavaInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.FieldNameOwner <em>Field Name Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.FieldNameOwner
	 * @generated
	 */
	public Adapter createFieldNameOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.Palette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.Palette
	 * @generated
	 */
	public Adapter createPaletteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.ImageFile <em>Image File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.ImageFile
	 * @generated
	 */
	public Adapter createImageFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotRepository <em>Snapshot Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
	 * @generated
	 */
	public Adapter createSnapshotRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup <em>Snapshot Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotGroup
	 * @generated
	 */
	public Adapter createSnapshotGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry <em>Snapshot Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry
	 * @generated
	 */
	public Adapter createSnapshotEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo <em>Shell Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.ShellInfo
	 * @generated
	 */
	public Adapter createShellInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.CommandHistory <em>Command History</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandHistory
	 * @generated
	 */
	public Adapter createCommandHistoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent <em>Command Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent
	 * @generated
	 */
	public Adapter createCommandEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PdetoolsAdapterFactory
