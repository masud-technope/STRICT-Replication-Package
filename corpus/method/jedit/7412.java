//}}}
//{{{ importFile
private boolean importFile(JComponent c, Transferable t) throws Exception {
    Log.log(Log.DEBUG, this, "=> File list");
    EditPane editPane = (EditPane) GUIUtilities.getComponentParent(c, EditPane.class);
    View view = editPane.getView();
    Buffer buffer = null;
    // per the Java API, javaFileListFlavor guarantees that a 
    // List<File> will be returned.  So suppress warning for this
    // statement.  We know what we're doing.
    @SuppressWarnings("unchecked") List<File> data = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
    boolean browsedDirectory = false;
    BufferSetManager bufferSetManager = jEdit.getBufferSetManager();
    for (File file : data) {
        if (file.isDirectory()) {
            if (!browsedDirectory) {
                VFSBrowser.browseDirectory(view, file.getPath());
                browsedDirectory = true;
            }
            continue;
        }
        Buffer _buffer = jEdit.openFile(editPane, file.getPath());
        if (_buffer != null) {
            buffer = _buffer;
            bufferSetManager.addBuffer(editPane, buffer);
        }
    }
    if (buffer != null)
        editPane.setBuffer(buffer);
    view.toFront();
    view.requestFocus();
    editPane.requestFocus();
    return true;
}