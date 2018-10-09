//}}}
//{{{ getActionSet() method
/**
	 * Returns the plugin's action set for the jEdit action context
	 * {@link jEdit#getActionContext()}. These actions are loaded from
	 * the <code>actions.xml</code> file; see {@link ActionSet}.
	 *.
	 * @since jEdit 4.2pre1
	 */
public ActionSet getActionSet() {
    return actions;
}