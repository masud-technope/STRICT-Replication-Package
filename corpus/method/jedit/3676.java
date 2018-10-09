//}}}
//{{{ handleKey() method
/**
	 * Handles a keystroke.
	 * @param keyStroke The key stroke.
	 * @return true if the input could be handled.
	 * @since jEdit 4.2pre5
	 */
public final boolean handleKey(KeyEventTranslator.Key keyStroke) {
    return handleKey(keyStroke, false);
}