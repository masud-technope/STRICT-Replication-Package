//}}}
//{{{ isPopupTrigger() method
/**
	 * Returns if the specified event is the popup trigger event.
	 * This implements precisely defined behavior, as opposed to
	 * MouseEvent.isPopupTrigger().
	 * @param evt The event
	 * @since jEdit 4.3pre7
	 */
public static boolean isPopupTrigger(MouseEvent evt) {
    return isRightButton(evt.getModifiersEx());
}