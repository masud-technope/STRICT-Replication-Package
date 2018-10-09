//{{{ dispose() method
private void dispose() {
    flushInput();
    for (int i = 0; i < buffer.getLineCount(); i++) {
        buffer.indentLine(i, true);
    }
    EditBus.removeFromBus(this);
    // setting the message to 'null' causes the status bar to
    // check if a recording is in progress
    view.getStatus().setMessage(null);
//}}}
}