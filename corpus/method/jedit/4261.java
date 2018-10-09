//}}}
//{{{ isPopupTrigger() method
/**
	 * Returns if the specified event is the popup trigger event.
	 * This implements precisely defined behavior, as opposed to
	 * MouseEvent.isPopupTrigger().
	 * @param evt The event
	 * @since jEdit 3.2pre8
	 * @deprecated use {@link GenericGUIUtilities#requestFocus(Window, Component)}
	 */
public static boolean isPopupTrigger(MouseEvent evt) {
    return GenericGUIUtilities.isPopupTrigger(evt);
}