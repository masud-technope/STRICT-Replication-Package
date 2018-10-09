//}}}
//{{{ startDragAndDrop() method
void startDragAndDrop(InputEvent evt, boolean copy) {
    TransferHandler transferHandler = getTransferHandler();
    if (transferHandler != null) {
        Log.log(Log.DEBUG, this, "Drag and drop callback");
        transferHandler.exportAsDrag(this, evt, copy ? TransferHandler.COPY : TransferHandler.MOVE);
    }
}