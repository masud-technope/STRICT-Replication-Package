private  GotoDelayed(EditPane editPane) {
    this.editPane = editPane;
    EditBus.addToBus(this);
    buffer = getBuffer(editPane.getView());
    if (buffer == null) {
        EditBus.removeFromBus(this);
        return;
    }
    editPane.setBuffer(buffer);
    synchronized (this) {
        if (!loadedEventReceived && buffer.isLoaded()) {
            bufferLoaded();
        }
    }
}