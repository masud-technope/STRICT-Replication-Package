//}}}
//{{{ showFilePopup() method
private void showFilePopup(VFSFile[] files, Component comp, Point point) {
    popup = new BrowserCommandsMenu(browser, files);
    // for the parent directory right-click; on the click we select
    // the clicked item, but when the popup goes away we select the
    // currently showing directory.
    popup.addPopupMenuListener(new PopupMenuListener() {

        public void popupMenuCanceled(PopupMenuEvent e) {
        }

        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        }

        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            // we use SwingUtilities.invokeLater()
            // so that the action is executed before
            // the popup is hidden.
            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    int index = parentDirectories.getModel().getSize() - 1;
                    parentDirectories.setSelectedIndex(index);
                }
            });
        }
    });
    GenericGUIUtilities.showPopupMenu(popup, comp, point.x, point.y);
}