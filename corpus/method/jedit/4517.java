//}}}
//{{{ resetLastActionCount() method
/**
	 * Resets the last action count. This should be called when an
	 * editing operation that is not an action is invoked, for example
	 * a mouse click.
	 * @since jEdit 4.0pre1
	 */
public void resetLastActionCount() {
    lastActionCount = 0;
}