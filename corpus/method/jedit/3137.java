public void valueChanged(ListSelectionEvent evt) {
    if (selectAllFlag)
        return;
    int index = bufferList.getSelectedIndex();
    if (index != -1) {
        String path = (String) bufferModel.getElementAt(index);
        Buffer buffer = jEdit.getBuffer(path);
        if (buffer == null) {
            // it seems this buffer was already closed
            Log.log(Log.DEBUG, this, "Buffer " + path + " is already closed");
            bufferModel.removeElementAt(index);
        } else {
            view.showBuffer(buffer);
        }
    }
    updateButtons();
}