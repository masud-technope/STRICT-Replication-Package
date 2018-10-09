//}}}
//{{{ getSettingsDirectory() method
/**
	 * Returns the path of the directory where user-specific settings
	 * are stored. This will be <code>null</code> if jEdit was
	 * started with the <code>-nosettings</code> command-line switch; do not
	 * blindly use this method without checking for a <code>null</code>
	 * return value first. <p>
	 *
	 * <b>NOTE</b>: plugins should <b>not</b> use this directory as a base to
	 * store their files. Instead, they should use EditPlugin.getPluginHome().
	 * @see EditPlugin#getPluginHome()
	 */
public static String getSettingsDirectory() {
    return settingsDirectory;
}