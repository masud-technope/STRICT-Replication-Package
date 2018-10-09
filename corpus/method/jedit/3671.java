//}}}
//{{{ processKeyEventSub() method
private void processKeyEventSub(boolean focusOnTextArea) {
    // the above
    if (view.isClosed())
        return;
    // search bar if the search bar has focus...
    if (isPrefixActive()) {
        Component focusOwner = view.getFocusOwner();
        if (focusOwner instanceof JTextComponent) {
            view.setPrefixFocusOwner(focusOwner);
            view.getTextArea().requestFocus();
        } else if (focusOnTextArea) {
            view.getTextArea().requestFocus();
        } else {
            view.setPrefixFocusOwner(null);
        }
    } else {
        view.setPrefixFocusOwner(null);
    }
}