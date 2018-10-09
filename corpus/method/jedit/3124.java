@Override
public boolean canImport(TransferSupport support) {
    if (!support.isDataFlavorSupported(BufferSwitcher.BufferDataFlavor)) {
        return false;
    }
    JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
    if (dl.getIndex() == -1) {
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
    EditPane sourceEditPane = (EditPane) GUIUtilities.getComponentParent(data.getSource(), EditPane.class);
    EditPane targetEditPane = (EditPane) GUIUtilities.getComponentParent(target, EditPane.class);
    BufferSet.Scope scope = jEdit.getBufferSetManager().getScope();
    View sourceView = sourceEditPane.getView();
    View targetView = targetEditPane.getView();
    switch(scope) {
        case editpane:
            {
                return sourceEditPane != targetEditPane;
            }
        case view:
            {
                return sourceView != targetView;
            }
        case global:
            return false;
    }
    return false;
}