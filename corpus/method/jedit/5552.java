//}}}
//{{{ _init() method
@Override
protected void _init() {
    undoCount = new JTextField(jEdit.getProperty("buffer.undoCount"));
    addComponent(jEdit.getProperty("options.editing.undoCount"), undoCount);
    // Reset Undo Manager On Save
    resetUndoOnSave = new JCheckBox(jEdit.getProperty("options.general.resetUndo"));
    resetUndoOnSave.setSelected(jEdit.getBooleanProperty("resetUndoOnSave"));
    addComponent(resetUndoOnSave);
}