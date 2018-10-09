//}}}
//{{{ isSelected() method
public boolean isSelected(Component comp) {
    if (isSelected == null)
        return false;
    NameSpace global = BeanShell.getNameSpace();
    try {
        View view = GUIUtilities.getView(comp);
        if (view == null)
            view = jEdit.getActiveView();
        // undocumented hack to allow browser actions to work.
        // XXX - clean up in 4.3
        global.setVariable("_comp", comp);
        return Boolean.TRUE.equals(BeanShell.runCachedBlock(isSelected.get(), view, new NameSpace(BeanShell.getNameSpace(), "BeanShellAction.isSelected()")));
    } catch (Throwable e) {
        Log.log(Log.ERROR, this, e);
        isSelected = null;
        return false;
    } finally {
        try {
            global.setVariable("_comp", null);
        } catch (UtilEvalError err) {
            Log.log(Log.ERROR, this, err);
        }
    }
}