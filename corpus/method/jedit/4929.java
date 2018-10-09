//{{{ invokeAction() method
/**
	 * Invokes the given action in response to a user-generated event.
	 * @param evt The event
	 * @param action The action
	 * @since jEdit 4.3pre13
	 */
public abstract void invokeAction(EventObject evt, F action);