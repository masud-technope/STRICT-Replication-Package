//}}}
//{{{ loadBufferSwitcher() method
void loadBufferSwitcher() {
    if (jEdit.getBooleanProperty("view.showBufferSwitcher")) {
        if (bufferSwitcher == null) {
            bufferSwitcher = new BufferSwitcher(this);
            add(BorderLayout.NORTH, bufferSwitcher);
            bufferSwitcher.updateBufferList();
            revalidate();
        }
    } else if (bufferSwitcher != null) {
        remove(bufferSwitcher);
        revalidate();
        bufferSwitcher = null;
    }
}