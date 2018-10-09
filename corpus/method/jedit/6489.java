//}}}
//{{{ loadMode() method
public void loadMode(Mode mode, XModeHandler xmh) {
    String fileName = (String) mode.getProperty("file");
    Log.log(Log.NOTICE, this, "Loading edit mode " + fileName);
    XMLReader parser;
    try {
        parser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
    } catch (SAXException | ParserConfigurationException saxe) {
        Log.log(Log.ERROR, this, saxe);
        return;
    }
    mode.setTokenMarker(xmh.getTokenMarker());
    InputStream grammar;
    try {
        grammar = new BufferedInputStream(new FileInputStream(fileName));
    } catch (FileNotFoundException e1) {
        InputStream resource = ModeProvider.class.getResourceAsStream(fileName);
        if (resource == null)
            error(fileName, e1);
        grammar = new BufferedInputStream(resource);
    }
    try {
        InputSource isrc = new InputSource(grammar);
        isrc.setSystemId("jedit.jar");
        parser.setContentHandler(xmh);
        parser.setDTDHandler(xmh);
        parser.setEntityResolver(xmh);
        parser.setErrorHandler(xmh);
        parser.parse(isrc);
        mode.setProperties(xmh.getModeProperties());
    } catch (Throwable // NOPMD
    e) {
        error(fileName, e);
    } finally {
        IOUtilities.closeQuietly(grammar);
    }
}