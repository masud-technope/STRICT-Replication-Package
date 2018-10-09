@Override
public void exportDone(JComponent c, Transferable t, int action) {
    if (action == MOVE) {
        BufferTransferableData data;
        try {
            data = (BufferTransferableData) t.getTransferData(BufferSwitcher.BufferDataFlavor);
        } catch (UnsupportedFlavorException e) {
            return;
        } catch (IOException e) {
            return;
        }
        Buffer buffer = data.getBuffer();
        EditPane editPane = (EditPane) GUIUtilities.getComponentParent(c, EditPane.class);
        BufferSetManager bufferSetManager = jEdit.getBufferSetManager();
        if (buffer != null) {
            bufferSetManager.removeBuffer(editPane, buffer);
        }
    }
}