@Override
public void update() {
    JEditTextArea textArea = view.getTextArea();
    if (textArea != null) {
        if (textArea.isMultipleSelectionEnabled()) {
            multiSelect.setText("M");
            multiSelect.setEnabled(true);
        } else {
            multiSelect.setText("m");
            multiSelect.setEnabled(false);
        }
    }
}