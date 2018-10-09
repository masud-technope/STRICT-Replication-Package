@Override
public void windowActivated(WindowEvent evt) {
    boolean appFocus = false;
    boolean viewChanged = false;
    View oldView = jEdit.getActiveViewInternal();
    // check if view is changed
    if (oldView != View.this)
        viewChanged = true;
    /* ACTIVATED currently means whenever the View gets focus.
			Ideally it should be only when the View changes or we are
			focusing on a View after previously using in another application.
			Currently, we also get ACTIVATED messages after a closed jEdit dialog.
			I consider this a bug which we should fix some day. */
    if (evt.getOppositeWindow() == null)
        appFocus = true;
    jEdit.setActiveView(View.this);
    //			Log.log(Log.DEBUG, this, "appFocus:" + appFocus + " viewChanged:" + viewChanged);
    if (appFocus || viewChanged)
        EditBus.send(new ViewUpdate(View.this, ViewUpdate.ACTIVATED));
}