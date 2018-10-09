//{{{ handleMessage() methods
@EditBus.EBHandler
public void handleMessage(EditPaneUpdate message) {
    if (message.getWhat() == EditPaneUpdate.BUFFER_CHANGED && message.getEditPane().getView() == view) {
        update();
    }
}