//}}}
//{{{ invokeAction() method
/**
	 * Invokes the specified action, repeating and recording it as
	 * necessary.
	 * @param action The action
	 * @since jEdit 4.2pre1
	 */
@Override
public void invokeAction(String action) {
    invokeAction(getAction(action));
}