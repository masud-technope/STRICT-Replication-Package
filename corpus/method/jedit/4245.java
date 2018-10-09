//}}}
//{{{ init() method
static void init() {
    initializeDeprecatedIcons();
    // Load the icon theme but fallback on the old icons
    String theme = jEdit.getProperty("icon-theme", "tango");
    Log.log(Log.DEBUG, GUIUtilities.class, "Icon theme set to: " + theme);
    setIconPath("jeditresource:/org/gjt/sp/jedit/icons/themes/" + theme + '/');
    Log.log(Log.DEBUG, GUIUtilities.class, "Loading icon theme from: " + iconPath);
}