//{{{ Buffer constructor
 Buffer(String path, boolean newFile, boolean temp, Map props, boolean untitled) {
    super(props);
    textTokenMarker = jEdit.getMode("text").getTokenMarker();
    markers = new Vector<Marker>();
    setFlag(TEMPORARY, temp);
    setFlag(UNTITLED, untitled);
    // this must be called before any EditBus messages are sent
    setPath(path);
    setFlag(NEW_FILE, newFile);
    setFlag(AUTORELOAD, jEdit.getBooleanProperty("autoReload"));
    setFlag(AUTORELOAD_DIALOG, jEdit.getBooleanProperty("autoReloadDialog"));
    undoListeners = new Vector<BufferUndoListener>();
}