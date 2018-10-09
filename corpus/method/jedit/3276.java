//{{{ createDockableWindow() method
JComponent createDockableWindow(View view, String position) {
    // Avoid infinite recursion
    synchronized (this) {
        if (isBeingCreated)
            return null;
        isBeingCreated = true;
    }
    load();
    if (!loaded) {
        Log.log(Log.WARNING, this, "Outdated cache");
        return null;
    }
    NameSpace nameSpace = new NameSpace(BeanShell.getNameSpace(), "DockableWindowManager.Factory.createDockableWindow()");
    try {
        nameSpace.setVariable("position", position);
    } catch (UtilEvalError e) {
        Log.log(Log.ERROR, this, e);
    }
    JComponent win = (JComponent) BeanShell.eval(view, nameSpace, code);
    if (jEdit.getBooleanProperty("textColors")) {
        LookAndFeel laf = UIManager.getLookAndFeel();
        if (!laf.getID().equals("Metal")) {
            GUIUtilities.applyTextAreaColors(win);
        }
    }
    synchronized (this) {
        isBeingCreated = false;
    }
    return win;
//}}}
}