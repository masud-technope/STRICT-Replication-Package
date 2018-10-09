//}}}
//{{{ isPopupTrigger() method
/**
	 * Returns if the specified event is the popup trigger event.
	 * This implements precisely defined behavior, as opposed to
	 * MouseEvent.isPopupTrigger().
	 * @param evt The event
	 * @since jEdit 5.3.1
	 */
public static boolean isPopupTrigger(MouseEvent evt) {
    return TextAreaMouseHandler.isRightButton(evt.getModifiersEx());
}