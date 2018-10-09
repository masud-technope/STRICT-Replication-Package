@Override
public void invokeAction(EventObject evt, EditAction action) {
    Component source = (Component) evt.getSource();
    VFSBrowser browser = (VFSBrowser) GUIUtilities.getComponentParent(source, VFSBrowser.class);
    VFSFile[] files = browser.getSelectedFiles(source);
    // in the future we will want something better,
    // eg. having an 'evt' object passed to
    // EditAction.invoke().
    // for now, since all browser actions are
    // written in beanshell we set the 'browser'
    // variable directly.
    NameSpace global = BeanShell.getNameSpace();
    try {
        global.setVariable("browser", browser);
        global.setVariable("files", files);
        View view = browser.getView();
        // them all
        if (view == null)
            view = jEdit.getActiveView();
        action.invoke(view);
    } catch (UtilEvalError err) {
        Log.log(Log.ERROR, this, err);
    } finally {
        try {
            global.setVariable("browser", null);
            global.setVariable("files", null);
        } catch (UtilEvalError err) {
            Log.log(Log.ERROR, this, err);
        }
    }
}