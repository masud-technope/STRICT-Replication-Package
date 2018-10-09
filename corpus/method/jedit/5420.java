//}}}
//{{{ _save() method
public void _save() {
    jEdit.setBooleanProperty("view.dragAndDrop", dragAndDrop.isSelected());
    jEdit.setBooleanProperty("view.joinNonWordChars", joinNonWordChars.isSelected());
    jEdit.setBooleanProperty("view.middleMousePaste", middleMousePaste.isSelected());
    jEdit.setBooleanProperty("view.ctrlForRectangularSelection", ctrlForRectangularSelection.isSelected());
    int c = clickModifierKeys.length;
    for (int i = 0; i < c; i++) {
        int idx = gutterClickActions[i].getSelectedIndex();
        jEdit.setProperty("view.gutter." + clickModifierKeys[i], clickActionKeys[idx]);
    }
}