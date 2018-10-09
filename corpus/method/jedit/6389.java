/**
	 * Construct a SettingsXML with specific location and name.
	 * @param settingsDirectory
	 * 	The settings directory of jedit
	 * @param name
	 * 	The file name will be (name + ".xml")
	 */
public  SettingsXML(String settingsDirectory, String name) {
    String filename = name + ".xml";
    file = new File(MiscUtilities.constructPath(settingsDirectory, filename));
}