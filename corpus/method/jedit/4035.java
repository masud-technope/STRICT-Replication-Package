private void cleanupStatusBar(MouseEvent evt) {
    if (msgSet) {
        StatusBar statusBar = GUIUtilities.getView((Component) evt.getSource()).getStatus();
        if (msg == statusBar.getMessage()) {
            statusBar.setMessage(null);
        }
        msgSet = false;
        msg = null;
    }
}