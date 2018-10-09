//}}}
//{{{ processKeyEvent() method
public void processKeyEvent(KeyEvent evt) {
    if (evt.getID() == KeyEvent.KEY_PRESSED) {
        String path = getText();
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_TAB:
                doComplete(path);
                break;
            case KeyEvent.VK_LEFT:
                if ((evt.getModifiersEx() & KeyEvent.ALT_DOWN_MASK) == KeyEvent.ALT_DOWN_MASK) {
                    browser.previousDirectory();
                    evt.consume();
                } else {
                    // 				browser.getBrowserView().getTable().processKeyEvent(evt);
                    super.processKeyEvent(evt);
                }
                break;
            case KeyEvent.VK_UP:
                if ((evt.getModifiersEx() & KeyEvent.ALT_DOWN_MASK) == KeyEvent.ALT_DOWN_MASK) {
                    String p = browser.getDirectory();
                    browser.setDirectory(MiscUtilities.getParentOfPath(p));
                    evt.consume();
                } else {
                    browser.getBrowserView().getTable().processKeyEvent(evt);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if ((evt.getModifiersEx() & KeyEvent.ALT_DOWN_MASK) == KeyEvent.ALT_DOWN_MASK) {
                    evt.consume();
                    browser.nextDirectory();
                } else
                    super.processKeyEvent(evt);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_PAGE_DOWN:
                browser.getBrowserView().getTable().processKeyEvent(evt);
                break;
            case KeyEvent.VK_ENTER:
                browser.filesActivated((evt.isShiftDown() ? VFSBrowser.M_OPEN_NEW_VIEW : VFSBrowser.M_OPEN), false);
                setText(null);
                evt.consume();
                break;
            default:
                super.processKeyEvent(evt);
                break;
        }
    } else if (evt.getID() == KeyEvent.KEY_TYPED) {
        char ch = evt.getKeyChar();
        if (ch > 0x20 && ch != 0x7f && ch != 0xff) {
            super.processKeyEvent(evt);
            String path = getText();
            BrowserView view = browser.getBrowserView();
            view.selectNone();
            if (MiscUtilities.getLastSeparatorIndex(path) == -1) {
                int mode = browser.getMode();
                // fix for bug #765507
                // we don't type complete in save dialog
                // boxes. Press TAB to do an explicit
                // complete
                view.getTable().doTypeSelect(path, mode == VFSBrowser.CHOOSE_DIRECTORY_DIALOG || mode == VFSBrowser.SAVE_DIALOG);
            }
        } else
            super.processKeyEvent(evt);
    }
}