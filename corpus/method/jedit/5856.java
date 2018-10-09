/**
	 * Create and install any sub-components.
	 */
public void installComponents() {
    printPreviewRenderer = new PrintPreviewRenderer();
    scrollPane = new JScrollPane(printPreviewRenderer);
    scrollPane.getVerticalScrollBar().setUnitIncrement(20);
    printPreviewPane.add(scrollPane, BorderLayout.CENTER);
}