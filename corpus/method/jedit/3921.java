@Override
public boolean importData(JComponent comp, Transferable t) {
    try {
        @SuppressWarnings({ "unchecked" }) E[] transferData = (E[]) t.getTransferData(MyTransferable.javaListFlavor);
        JList targetList = (JList) comp;
        @SuppressWarnings({ "unchecked" }) MyListModel<E> targetModel = (MyListModel<E>) targetList.getModel();
        @SuppressWarnings({ "unchecked" }) MyListModel<E> sourceModel = (MyListModel<E>) sourceList.getModel();
        int dropLocation = targetList.getSelectedIndex();
        if (dropLocation == -1)
            dropLocation = 0;
        targetModel.add(dropLocation, transferData);
        int dropStart = dropLocation;
        if (targetList == sourceList) {
            // we are moving inside the same list
            for (int i = indices.length - 1; i >= 0; i--) {
                int index = indices[i];
                if (indices[i] >= dropLocation) {
                    index += transferData.length;
                } else {
                    dropStart--;
                }
                sourceModel.remove(index);
            }
            for (int i = indices.length - 1; i >= 0; i--) {
                indices[i] = dropStart + i;
            }
        } else {
            // we are moving to another list
            sourceList.clearSelection();
            for (int i = indices.length - 1; i >= 0; i--) {
                sourceModel.remove(indices[i]);
                indices[i] = dropLocation + i;
            }
        }
        targetList.setSelectedIndices(indices);
        return true;
    } catch (UnsupportedFlavorException e) {
        Log.log(Log.ERROR, this, e);
    } catch (IOException e) {
        Log.log(Log.ERROR, this, e);
    }
    return false;
}