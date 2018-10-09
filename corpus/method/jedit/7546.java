//}}}
//{{{ setButtonContentMargin() method
/**
	 * Sets the content margin of a button (for Nimbus L&amp;F).
	 * @param button  the button to modify
	 * @param margin  the new margin
	 * @since jEdit 5.3.1
	 */
public static void setButtonContentMargin(AbstractButton button, Insets margin) {
    UIDefaults defaults = new UIDefaults();
    defaults.put("Button.contentMargins", margin);
    defaults.put("ToggleButton.contentMargins", margin);
    button.putClientProperty("Nimbus.Overrides", defaults);
}