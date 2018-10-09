//}}}
//{{{ close() method
void close() {
    EditBus.send(new ViewUpdate(this, ViewUpdate.CLOSED));
    closed = true;
    // save dockable window geometry, and close 'em
    dockableWindowManager.close();
    EditBus.removeFromBus(this);
    dispose();
    EditPane[] editPanes = getEditPanes();
    for (EditPane ep : editPanes) ep.close();
    // null some variables so that retaining references
    // to closed views won't hurt as much.
    toolBarManager = null;
    toolBar = null;
    searchBar = null;
    splitPane = null;
    inputHandler = null;
    recorder = null;
    getContentPane().removeAll();
    // notify clients with -wait
    if (waitSocket != null) {
        try {
            waitSocket.getOutputStream().write('\0');
            waitSocket.getOutputStream().flush();
            waitSocket.getInputStream().close();
            waitSocket.getOutputStream().close();
            waitSocket.close();
        } catch (IOException io) {
        }
    }
}