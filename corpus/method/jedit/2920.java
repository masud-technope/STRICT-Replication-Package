/**
		 * Called when the user selects this action from a menu.
		 * It passes the action through the
		 * {@link org.gjt.sp.jedit.gui.InputHandler#invokeAction(EditAction)}
		 * method, which performs any recording or repeating.
		 *
		 * @param evt The action event
		 */
public void actionPerformed(ActionEvent evt) {
    EditAction action = context.getAction(actionName);
    if (action == null) {
        Log.log(Log.WARNING, this, "Unknown action: " + actionName);
    } else
        context.invokeAction(evt, action);
}