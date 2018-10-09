//}}}
//{{{ processKeyEvent() method
@Override
public void processKeyEvent(KeyEvent evt) {
    if (evt.getID() == KeyEvent.KEY_PRESSED) {
        VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
        int row = getSelectedRow();
        ActionContext ac = VFSBrowser.getActionContext();
        ActionContext jac = jEdit.getActionContext();
        EditAction browserUp = ac.getAction("vfs.browser.up");
        VFSBrowser browser = browserView.getBrowser();
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                evt.consume();
                if ((evt.getModifiersEx() & ALT_DOWN_MASK) == ALT_DOWN_MASK) {
                    browser.previousDirectory();
                } else {
                    if (row != -1) {
                        if (model.files[row].expanded) {
                            toggleExpanded(row);
                            return;
                        }
                        for (int i = row - 1; i >= 0; i--) {
                            if (model.files[i].expanded && model.files[i].level < model.files[row].level) {
                                setSelectedRow(i);
                                return;
                            }
                        }
                    }
                    String dir = browserView.getBrowser().getDirectory();
                    dir = MiscUtilities.getParentOfPath(dir);
                    browserView.getBrowser().setDirectory(dir);
                }
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                if ((evt.getModifiersEx() & SHIFT_DOWN_MASK) == SHIFT_DOWN_MASK) {
                    browserView.getParentDirectoryList().requestFocus();
                } else {
                    browser.focusOnDefaultComponent();
                }
                break;
            case KeyEvent.VK_BACK_SPACE:
                evt.consume();
                ac.invokeAction(evt, browserUp);
                break;
            case KeyEvent.VK_UP:
                if ((evt.getModifiersEx() & ALT_DOWN_MASK) == ALT_DOWN_MASK) {
                    evt.consume();
                    ac.invokeAction(evt, browserUp);
                }
                break;
            case KeyEvent.VK_DELETE:
                evt.consume();
                EditAction deleteAct = ac.getAction("vfs.browser.delete");
                ac.invokeAction(evt, deleteAct);
                break;
            case KeyEvent.VK_N:
                if ((evt.getModifiersEx() & CTRL_DOWN_MASK) == CTRL_DOWN_MASK) {
                    evt.consume();
                    EditAction ea = ac.getAction("vfs.browser.new-file");
                    ac.invokeAction(evt, ea);
                }
                break;
            case KeyEvent.VK_INSERT:
                evt.consume();
                EditAction newDir = ac.getAction("vfs.browser.new-directory");
                ac.invokeAction(evt, newDir);
                break;
            case KeyEvent.VK_ESCAPE:
                EditAction cda = ac.getAction("vfs.browser.closedialog");
                ac.invokeAction(evt, cda);
                break;
            case KeyEvent.VK_F2:
                EditAction ren = ac.getAction("vfs.browser.rename");
                evt.consume();
                ac.invokeAction(evt, ren);
                break;
            case KeyEvent.VK_F5:
                evt.consume();
                EditAction reload = ac.getAction("vfs.browser.reload");
                ac.invokeAction(evt, reload);
                break;
            case KeyEvent.VK_F6:
            case KeyEvent.VK_RIGHT:
                evt.consume();
                if ((evt.getModifiersEx() & ALT_DOWN_MASK) == ALT_DOWN_MASK) {
                    browser.nextDirectory();
                } else if (row != -1) {
                    if (!model.files[row].expanded)
                        toggleExpanded(row);
                }
                break;
            case KeyEvent.VK_ENTER:
                evt.consume();
                browserView.getBrowser().filesActivated(evt.isShiftDown() ? VFSBrowser.M_OPEN_NEW_VIEW : VFSBrowser.M_OPEN, false);
                break;
        }
    } else if (evt.getID() == KeyEvent.KEY_TYPED) {
        if (evt.isControlDown() || evt.isAltDown() || evt.isMetaDown()) {
            evt.consume();
            return;
        }
        // hack...
        if (evt.isShiftDown() && evt.getKeyChar() == '\n') {
            evt.consume();
            return;
        }
        VFSBrowser browser = browserView.getBrowser();
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
            default:
                evt.consume();
                typeSelectBuffer.append(evt.getKeyChar());
                doTypeSelect(typeSelectBuffer.toString(), browser.getMode() == VFSBrowser.CHOOSE_DIRECTORY_DIALOG);
                timer.stop();
                timer.setInitialDelay(750);
                timer.setRepeats(false);
                timer.start();
                return;
        }
    }
    if (!evt.isConsumed())
        super.processKeyEvent(evt);
}