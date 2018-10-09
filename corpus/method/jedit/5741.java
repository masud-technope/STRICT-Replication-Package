//{{{ MirrorList constructor
public  MirrorList(boolean download, ProgressObserver observer) throws Exception {
    mirrors = new ArrayList<Mirror>();
    Mirror none = new Mirror();
    none.id = Mirror.NONE;
    none.description = none.location = none.country = none.continent = "";
    mirrors.add(none);
    String path = jEdit.getProperty("plugin-manager.mirror-url");
    MirrorListHandler handler = new MirrorListHandler(this, path);
    if (download) {
        Log.log(Log.NOTICE, this, "Loading mirror list from internet");
        downloadXml(path);
    } else {
        Log.log(Log.NOTICE, this, "Loading mirror list from cache");
        readXml();
    }
    if (xml == null)
        return;
    observer.setValue(1L);
    Reader in = new BufferedReader(new StringReader(xml));
    InputSource isrc = new InputSource(in);
    isrc.setSystemId("jedit.jar");
    XMLReader parser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
    parser.setContentHandler(handler);
    parser.setDTDHandler(handler);
    parser.setEntityResolver(handler);
    parser.setErrorHandler(handler);
    parser.parse(isrc);
    observer.setValue(2L);
}