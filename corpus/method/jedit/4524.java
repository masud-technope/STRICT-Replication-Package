//}}}
//{{{ processKeyEventSub() method
private void processKeyEventSub(boolean focusOnTextArea) {
    // search bar if the search bar has focus...
    if (isPrefixActive() && focusOnTextArea) {
        textArea.requestFocus();
    }
}