/**
	 * Configures the specified component appropriate for the look and feel.
	 * This method is invoked when the <code>ComponentUI</code> instance is being installed
	 * as the UI delegate on the specified component.  This method should
	 * completely configure the component for the look and feel,
	 * including the following:
	 * <ol>
	 * <li>Install any default property values for color, fonts, borders,
	 *     icons, opacity, etc. on the component.  Whenever possible,
	 *     property values initialized by the client program should <i>not</i>
	 *     be overridden.
	 * </li><li>Install a <code>LayoutManager</code> on the component if necessary.
	 * </li><li>Create/add any required sub-components to the component.
	 * </li><li>Create/install event listeners on the component.
	 * </li><li>Create/install a <code>PropertyChangeListener</code> on the component in order
	 *     to detect and respond to component property changes appropriately.
	 * </li><li>Install keyboard UI (mnemonics, traversal, etc.) on the component.
	 * </li><li>Initialize any appropriate instance data.
	 * </li></ol>
	 * @param c The actual component.
	 */
public void installUI(JComponent c) {
    printPreviewPane = (PrintPreviewPane) c;
    installDefaults();
    installComponents();
    installListeners();
}