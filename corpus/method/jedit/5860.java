public void stateChanged(ChangeEvent event) {
    if (printPreviewRenderer != null) {
        printPreviewRenderer.setSize(printPreviewRenderer.getPreferredSize());
        printPreviewRenderer.repaint();
    }
}