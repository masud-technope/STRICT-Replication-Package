//}}}
//{{{ handleKey() method
/**
	 * Handles a keystroke.
	 * @param keyStroke The key stroke.
	 * @param dryRun only calculate the return value, do not have any other effect
	 * @return true if the input could be handled.
	 * @since jEdit 4.3pre7
	 */
public abstract boolean handleKey(KeyEventTranslator.Key keyStroke, boolean dryRun);