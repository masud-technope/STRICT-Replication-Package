/**
	 * Required by super class.
	 * @param c not used
	 * @return one of these
	 */
public static ComponentUI createUI(JComponent c) {
    return new BasicPrintPreviewPaneUI();
}