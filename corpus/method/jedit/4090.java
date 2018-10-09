public void update() {
    JEditTextArea textArea = view.getTextArea();
    if (textArea != null) {
        if (textArea.isRectangularSelectionEnabled()) {
            rectSelect.setText("R");
            rectSelect.setEnabled(true);
        } else {
            rectSelect.setText("r");
            rectSelect.setEnabled(false);
        }
    }
}