@Override
public boolean importData(TransferSupport support) {
    if (!support.isDrop()) {
        return false;
    }
    Transferable t = support.getTransferable();
    BufferTransferableData data;
    try {
        data = (BufferTransferableData) t.getTransferData(BufferSwitcher.BufferDataFlavor);
    } catch (UnsupportedFlavorException e) {
        return false;
    } catch (IOException e) {
        return false;
    }
    JComponent target = (JComponent) support.getComponent();
    EditPane targetEditPane = (EditPane) GUIUtilities.getComponentParent(target, EditPane.class);
    Buffer buffer = data.getBuffer();
    View view = targetEditPane.getView();
    BufferSetManager bufferSetManager = jEdit.getBufferSetManager();
    if (buffer != null) {
        bufferSetManager.addBuffer(targetEditPane, buffer);
        targetEditPane.setBuffer(buffer);
    }
    view.toFront();
    view.requestFocus();
    targetEditPane.requestFocus();
    return true;
}