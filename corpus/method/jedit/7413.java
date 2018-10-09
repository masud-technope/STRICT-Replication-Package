//}}}
//{{{ importURIList
private boolean importURIList(JComponent c, Transferable t, DataFlavor uriListStringDataFlavor) throws Exception {
    String str = (String) t.getTransferData(uriListStringDataFlavor);
    Log.log(Log.DEBUG, this, "=> URIList \"" + str + '\"');
    EditPane editPane = (EditPane) GUIUtilities.getComponentParent(c, EditPane.class);
    View view = editPane.getView();
    JEditTextArea textArea = (JEditTextArea) c;
    if (dragSource == null) {
        boolean found = false;
        String[] components = str.split("\r\n");
        boolean browsedDirectory = false;
        for (int i = 0; i < components.length; i++) {
            String str0 = components[i];
            // gnome-commander adds a 0 byte at the end of the file name, discard it
            int len = str0.length();
            if (len > 0 && (int) str0.charAt(len - 1) == 0)
                str0 = str0.substring(0, len - 1);
            if (str0.length() > 0) {
                // this handles the URI-decoding
                URI uri = new URI(str0);
                if ("file".equals(uri.getScheme())) {
                    File file = new File(uri.getPath());
                    if (file.isDirectory()) {
                        if (!browsedDirectory) {
                            VFSBrowser.browseDirectory(view, file.getPath());
                            browsedDirectory = true;
                        }
                    } else {
                        AwtRunnableQueue.INSTANCE.runAfterIoTasks(new DraggedURLLoader(textArea, uri.getPath()));
                    }
                    found = true;
                } else {
                    Log.log(Log.DEBUG, this, "I do not know how to handle this URI " + uri + ", ignoring.");
                }
            } else {
                // This should be the last component, because every URI in the list is terminated with a "\r\n", even the last one.
                if (i != components.length - 1) {
                    Log.log(Log.DEBUG, this, "Odd: there is an empty line in the uri list which is not the last line.");
                }
            }
        }
        if (found) {
            return true;
        }
    }
    return true;
}