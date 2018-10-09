//}}}
//{{{ isSelected() method
public boolean isSelected(Component comp) {
    if (isSelected == null)
        return false;
    NameSpace global = bsh.getNameSpace();
    try {
        if (cachedIsSelected == null) {
            String cachedIsSelectedName = "selected_" + sanitizedName;
            cachedIsSelected = bsh.cacheBlock(cachedIsSelectedName, isSelected, true);
        }
        // undocumented hack to allow browser actions to work.
        // XXX - clean up in 4.3
        global.setVariable("_comp", comp);
        return Boolean.TRUE.equals(bsh.runCachedBlock(cachedIsSelected, null, new NameSpace(bsh.getNameSpace(), "BeanShellAction.isSelected()")));
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