//}}}
//{{{ loadIcon() method
/**
	 * Loads an icon.
	 * @param iconName The icon name
	 * @return the icon
	 * @since jEdit 2.6pre7
	 */
public static Icon loadIcon(String iconName) {
    if (iconName == null)
        return null;
    // * Enable old icon naming scheme support
    if (deprecatedIcons != null && deprecatedIcons.containsKey(iconName))
        iconName = deprecatedIcons.get(iconName);
    // check if there is a cached version first
    Map<String, Icon> cache = null;
    if (iconCache != null) {
        cache = iconCache.get();
    }
    if (cache == null) {
        cache = new Hashtable<String, Icon>();
        iconCache = new SoftReference<Map<String, Icon>>(cache);
    }
    Icon icon = cache.get(iconName);
    if (icon != null)
        return icon;
    URL url;
    try {
        // get the icon
        if (MiscUtilities.isURL(iconName))
            url = new URL(iconName);
        else
            url = new URL(iconPath + iconName);
    } catch (Exception e) {
        try {
            url = new URL(defaultIconPath + iconName);
        } catch (Exception ex) {
            Log.log(Log.ERROR, GUIUtilities.class, "Icon not found: " + iconName);
            Log.log(Log.ERROR, GUIUtilities.class, ex);
            return null;
        }
    }
    icon = new ImageIcon(url);
    cache.put(iconName, icon);
    return icon;
}