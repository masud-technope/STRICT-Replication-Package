//}}}
//{{{ loadPerspective() method
public static View loadPerspective(boolean restoreFiles) {
    if (perspectiveXML == null)
        return null;
    if (!perspectiveXML.fileExists())
        return null;
    Log.log(Log.MESSAGE, PerspectiveManager.class, "Loading " + perspectiveXML);
    PerspectiveHandler handler = new PerspectiveHandler(restoreFiles);
    try {
        perspectiveXML.load(handler);
    } catch (IOException e) {
        Log.log(Log.ERROR, PerspectiveManager.class, e);
    }
    return handler.view;
}