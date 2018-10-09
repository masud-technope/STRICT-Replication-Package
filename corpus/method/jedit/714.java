@Override
protected void processKeyEvent(KeyEvent evt) {
    if (evt.getID() == KeyEvent.KEY_PRESSED) {
        ActionContext ac = VFSBrowser.getActionContext();
        int row = parentDirectories.getSelectedIndex();
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                evt.consume();
                if (row < parentDirectories.getSize().height - 1)
                    parentDirectories.setSelectedIndex(++row);
                break;
            case KeyEvent.VK_LEFT:
                if ((evt.getModifiersEx() & ALT_DOWN_MASK) == ALT_DOWN_MASK) {
                    evt.consume();
                    browser.previousDirectory();
                } else
                    super.processEvent(evt);
                break;
            case KeyEvent.VK_RIGHT:
                if ((evt.getModifiersEx() & ALT_DOWN_MASK) == ALT_DOWN_MASK) {
                    evt.consume();
                    browser.nextDirectory();
                } else
                    super.processEvent(evt);
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                if ((evt.getModifiersEx() & SHIFT_DOWN_MASK) == SHIFT_DOWN_MASK)
                    browser.focusOnDefaultComponent();
                else
                    table.requestFocus();
                break;
            case KeyEvent.VK_UP:
                evt.consume();
                if (row > 0) {
                    parentDirectories.setSelectedIndex(--row);
                }
                break;
            case KeyEvent.VK_BACK_SPACE:
                evt.consume();
                EditAction up = ac.getAction("vfs.browser.up");
                ac.invokeAction(evt, up);
                break;
            case KeyEvent.VK_F5:
                evt.consume();
                EditAction reload = ac.getAction("vfs.browser.reload");
                ac.invokeAction(evt, reload);
                break;
            case KeyEvent.VK_ENTER:
                evt.consume();
                if (row != -1) {
                    // basically the same handling as in ParentMouseHandler#mouseReleased
                    Object obj = parentDirectories.getModel().getElementAt(row);
                    if (obj instanceof VFSFile) {
                        VFSFile dirEntry = (VFSFile) obj;
                        browser.setDirectory(dirEntry.getPath());
                        if (browser.getMode() == VFSBrowser.BROWSER)
                            focusOnFileView();
                    }
                }
                break;
        }
    } else if (evt.getID() == KeyEvent.KEY_TYPED) {
        if (evt.isControlDown() || evt.isAltDown() || evt.isMetaDown()) {
            evt.consume();
            return;
        }
        switch(evt.getKeyChar()) {
            case '~':
                evt.consume();
                if (browser.getMode() == VFSBrowser.BROWSER)
                    browser.setDirectory(System.getProperty("user.home"));
                break;
            case '/':
                evt.consume();
                if (browser.getMode() == VFSBrowser.BROWSER)
                    browser.rootDirectory();
                break;
            case '-':
                evt.consume();
                if (browser.getMode() == VFSBrowser.BROWSER) {
                    browser.setDirectory(browser.getView().getBuffer().getDirectory());
                }
                break;
        }
    }
    if (!evt.isConsumed())
        super.processKeyEvent(evt);
}