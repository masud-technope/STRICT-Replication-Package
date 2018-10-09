/**
	 * Tear down and clean up.
	 */
public void uninstallUI(JComponent c) {
    c.setLayout(null);
    uninstallListeners();
    uninstallComponents();
    uninstallDefaults();
    printPreviewPane = null;
}