/**
		 * Creates a new action listener wrapper.
		 * @param context the action context
		 * @param actionName the name of the action
		 * @since jEdit 4.2pre1
		 */
public  Wrapper(ActionContext context, String actionName) {
    this.context = context;
    this.actionName = actionName;
}