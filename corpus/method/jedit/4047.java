@EditBus.EBHandler
public void handleMessage(BufferUpdate message) {
    if (message.getBuffer() == view.getBuffer()) {
        update();
    }
//}}}
}