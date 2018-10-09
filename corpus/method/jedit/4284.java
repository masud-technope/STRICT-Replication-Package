//{{{ Icon methods
//{{{ setIconPath() method
/**
	 * Sets the path where jEdit looks for icons.
	 * @param iconPath the icon path
	 * @since jEdit 4.2pre5
	 */
public static void setIconPath(String iconPath) {
    GUIUtilities.iconPath = iconPath;
    iconCache = null;
}