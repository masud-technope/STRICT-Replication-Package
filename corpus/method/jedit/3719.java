//}}}
//{{{ getModifierString() method
/**
	 * Returns a string containing symbolic modifier names set in the
	 * specified event.
	 *
	 * @param evt The event
	 *
	 * @since jEdit 4.2pre3
	 */
public static String getModifierString(InputEvent evt) {
    StringBuilder buf = new StringBuilder();
    if (evt.isControlDown())
        buf.append(getSymbolicModifierName(InputEvent.CTRL_DOWN_MASK));
    if (evt.isAltDown())
        buf.append(getSymbolicModifierName(InputEvent.ALT_DOWN_MASK));
    if (evt.isMetaDown())
        buf.append(getSymbolicModifierName(InputEvent.META_DOWN_MASK));
    if (evt.isShiftDown())
        buf.append(getSymbolicModifierName(InputEvent.SHIFT_DOWN_MASK));
    return buf.length() == 0 ? null : buf.toString();
}