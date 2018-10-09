//}}}
//{{{ loadMenuItem(EditAction, boolean)
public static JMenuItem loadMenuItem(EditAction editAction, boolean setMnemonic) {
    String name = editAction.getName();
    ActionContext context = jEdit.getActionContext();
    return _loadMenuItem(name, context, setMnemonic);
}