public void mouseEntered(MouseEvent evt) {
    msg = jEdit.getProperty(msgKey);
    if (msg != null) {
        GUIUtilities.getView((Component) evt.getSource()).getStatus().setMessage(msg);
        msgSet = true;
    }
}