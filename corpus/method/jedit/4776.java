//}}}
//}}}
//{{{ Miscellaneous methods
//{{{ relocateSettings() method
public static void relocateSettings() {
    String oldSettingsPath = MiscUtilities.constructPath(System.getProperty("user.home"), ".jedit");
    File oldSettingsDir = new File(oldSettingsPath);
    File newSettingsDir = new File(settingsDirectory);
    if (oldSettingsDir.exists() && !newSettingsDir.exists()) {
        Log.log(Log.NOTICE, jEdit.class, "Old settings directory found (HOME/.jedit). Moving to new location (" + newSettingsDir + ')');
        try {
            oldSettingsDir.renameTo(newSettingsDir);
        } catch (SecurityException se) {
            Log.log(Log.ERROR, jEdit.class, se);
        }
    }
}