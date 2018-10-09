//}}}
//{{{ getBrowserActionSet() method
/**
	 * Returns the plugin's action set for the file system browser action
	 * context {@link
	 * VFSBrowser#getActionContext()}.
	 * These actions are loaded from
	 * the <code>browser.actions.xml</code> file; see {@link ActionSet}.
	 *.
	 * @since jEdit 4.2pre1
	 */
public ActionSet getBrowserActionSet() {
    return browserActions;
}