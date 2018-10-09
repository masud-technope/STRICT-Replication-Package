//}}}
//{{{ bufferLoaded() method
public void bufferLoaded(JEditBuffer buffer) {
    displayManager.bufferLoaded();
    textArea._finishCaretUpdate();
}