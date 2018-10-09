//}}}
//{{{ setAutoWrap() method
/**
	 * Sets the state of the auto wrap around flag.
	 * @param wrap If true, the 'continue search from start' dialog
	 * will not be displayed
	 * @since jEdit 3.2pre2
	 */
public static void setAutoWrapAround(boolean wrap) {
    if (wrap == SearchAndReplace.wrap)
        return;
    SearchAndReplace.wrap = wrap;
    EditBus.send(new SearchSettingsChanged(null));
}