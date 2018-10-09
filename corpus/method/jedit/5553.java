//}}}
//{{{ _save() method
@Override
protected void _save() {
    jEdit.setProperty("buffer.undoCount", undoCount.getText());
    jEdit.setBooleanProperty("resetUndoOnSave", resetUndoOnSave.isSelected());
}