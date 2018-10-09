//}}}
//{{{ initInputHandler() method
/**
	 * Creates an actionContext and initializes the input
	 * handler for this textarea. Called when creating
	 * a standalone textarea from within jEdit.
	 */
public void initInputHandler() {
    actionContext = new JEditActionContext<JEditBeanShellAction, JEditActionSet<JEditBeanShellAction>>() {

        @Override
        public void invokeAction(EventObject evt, JEditBeanShellAction action) {
            action.invoke(TextArea.this);
        }
    };
    setMouseHandler(new TextAreaMouseHandler(this));
    inputHandlerProvider = new DefaultInputHandlerProvider(new TextAreaInputHandler(this) {

        @Override
        protected JEditBeanShellAction getAction(String action) {
            return actionContext.getAction(action);
        }
    });
}