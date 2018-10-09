//}}}
//{{{ setButtonContentMargin() method
/**
	 * Sets the content margin of a button (for Nimbus L&amp;F).
	 * @param button  the button to modify
	 * @param margin  the new margin
	 * @since jEdit 5.3
	 * @deprecated use {@link GenericGUIUtilities#setButtonContentMargin(AbstractButton, Insets)}
	 */
public static void setButtonContentMargin(AbstractButton button, Insets margin) {
    GenericGUIUtilities.setButtonContentMargin(button, margin);
}