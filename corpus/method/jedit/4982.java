//{{{ Constructor
 JEditRegisterSaver() {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory != null) {
        registersXML = new SettingsXML(settingsDirectory, "registers");
    }
}