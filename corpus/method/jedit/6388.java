//}}}
//{{{ load() method
/**
	 * Parse the XML file to load.
	 * @param handler
	 * 	The handler to receive SAX notifications.
	 */
public void load(DefaultHandler handler) throws IOException {
    XMLUtilities.parseXML(new FileInputStream(file), handler);
    knownLastModified = file.lastModified();
}