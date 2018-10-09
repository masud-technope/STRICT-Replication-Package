//}}}
//{{{ close() method
void close() {
    saveCaretInfo();
    EditBus.send(new EditPaneUpdate(this, EditPaneUpdate.DESTROYED));
    EditBus.removeFromBus(this);
    textArea.dispose();
}