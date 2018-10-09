//{{{ update() method
public void update() {
    JEditTextArea textArea = view.getTextArea();
    if (textArea != null) {
        if (textArea.isOverwriteEnabled()) {
            overwrite.setText("O");
            overwrite.setEnabled(true);
        } else {
            overwrite.setText("o");
            overwrite.setEnabled(false);
        }
    }
//}}}
}