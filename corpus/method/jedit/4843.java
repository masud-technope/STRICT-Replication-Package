//}}}
//{{{ initSystemProperties() method
/**
	 * Load system properties.
	 */
private static void initSystemProperties() {
    propMgr = new PropertyManager();
    try {
        propMgr.loadSystemProps(getResourceAsUTF8Text("/org/gjt/sp/jedit/jedit.props"));
        propMgr.loadSystemProps(getResourceAsUTF8Text("/org/gjt/sp/jedit/jedit_gui.props"));
        propMgr.loadSystemProps(getResourceAsUTF8Text("/org/jedit/localization/jedit_en.props"));
    } catch (Exception e) {
        Log.log(Log.ERROR, jEdit.class, "Error while loading system properties!");
        Log.log(Log.ERROR, jEdit.class, "One of the following property files could not be loaded:\n" + "- jedit.props\n" + "- jedit_gui.props\n" + "- jedit_en.props\n" + "jedit.jar is probably corrupt.");
        Log.log(Log.ERROR, jEdit.class, e);
        System.exit(1);
    }
}