//}}}
//{{{ _save() method
@Override
protected void _save() {
    jEdit.setProperty("keymap.current", selectedKeymap.toString());
    if (keyTable.getCellEditor() != null)
        keyTable.getCellEditor().stopCellEditing();
    for (ShortcutsModel model : models) model.save();
    Macros.loadMacros();
    selectedKeymap.save();
}