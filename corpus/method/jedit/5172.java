//}}}
//{{{ startElement() method
public void startElement(String uri, String localName, String qName, Attributes attrs) {
    if (qName.equals("MODE")) {
        String modeName = attrs.getValue("NAME");
        String file = attrs.getValue("FILE");
        if (file == null) {
            Log.log(Log.ERROR, this, directory + "catalog:" + " mode " + modeName + " doesn't have" + " a FILE attribute");
        }
        String filenameGlob = attrs.getValue("FILE_NAME_GLOB");
        String firstlineGlob = attrs.getValue("FIRST_LINE_GLOB");
        Mode mode = instantiateMode(modeName);
        ModeProvider.instance.addMode(mode);
        Object path;
        if (resource)
            path = jEdit.class.getResource(directory + file);
        else
            path = MiscUtilities.constructPath(directory, file);
        mode.setProperty("file", path);
        mode.unsetProperty("filenameGlob");
        if (filenameGlob != null)
            mode.setProperty("filenameGlob", filenameGlob);
        mode.unsetProperty("firstlineGlob");
        if (firstlineGlob != null)
            mode.setProperty("firstlineGlob", firstlineGlob);
        mode.init();
    }
}