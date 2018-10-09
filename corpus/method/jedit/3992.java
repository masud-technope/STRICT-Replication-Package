//{{{ handleMessage() method
public void handleMessage(EBMessage message) {
    if (message instanceof PropertiesChanged) {
        PropertiesChanged propertiesChanged = (PropertiesChanged) message;
        if (propertiesChanged.getSource() instanceof BufferSetManager) {
            update();
        }
    }
//}}}
}