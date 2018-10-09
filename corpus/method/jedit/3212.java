//}}}
//{{{ getModifierString() method
/**
	 * Returns a string containing symbolic modifier names set in the
	 * specified event.
	 *
	 * @param evt The event
	 *
	 * @since jEdit 4.1pre3
	 */
public static String getModifierString(InputEvent evt) {
    return KeyEventTranslator.getModifierString(evt);
}