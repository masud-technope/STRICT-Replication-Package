//{{{ Constructor
 JEditKillRing() {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory != null) {
        killringXML = new SettingsXML(settingsDirectory, "killring");
    }
}