public void updateUI() {
    if (UIManager.get(getUIClassID()) != null) {
        setUI((PrintPreviewPaneUI) UIManager.getUI(this));
    } else {
        setUI(new BasicPrintPreviewPaneUI());
    }
    fireStateChanged();
}