/**
	 * This method does the "double-click" handling. It is public so that
	 * <code>browser.actions.xml</code> can bind to it.
	 * @since jEdit 4.2pre2
	 */
public void filesActivated(int mode, boolean canDoubleClickClose) {
    VFSFile[] selectedFiles = browserView.getSelectedFiles();
    Buffer buffer = null;
    check_selected: for (VFSFile file : selectedFiles) {
        if (file.getType() == VFSFile.DIRECTORY || file.getType() == VFSFile.FILESYSTEM) {
            if (mode == M_OPEN_NEW_VIEW && this.mode == BROWSER)
                browseDirectoryInNewWindow(view, file.getPath());
            else if (selectedFiles.length == 1)
                setDirectory(file.getPath());
        } else if (this.mode == BROWSER || this.mode == BROWSER_DIALOG) {
            if (mode == M_INSERT) {
                view.getBuffer().insertFile(view, file.getPath());
                continue check_selected;
            }
            Buffer _buffer = jEdit.getBuffer(file.getPath());
            if (_buffer == null) {
                Hashtable<String, Object> props = new Hashtable<String, Object>();
                if (currentEncoding != null) {
                    props.put(JEditBuffer.ENCODING, currentEncoding);
                }
                props.put(Buffer.ENCODING_AUTODETECT, autoDetectEncoding);
                _buffer = jEdit.openFile(view, null, file.getPath(), false, props);
            } else if (doubleClickClose && canDoubleClickClose && this.mode != BROWSER_DIALOG && selectedFiles.length == 1) {
                // close if this buffer is currently
                // visible in the view.
                EditPane[] editPanes = view.getEditPanes();
                for (EditPane editPane : editPanes) {
                    if (editPane.getBuffer() == _buffer) {
                        jEdit.closeBuffer(view, _buffer);
                        return;
                    }
                }
            }
            if (_buffer != null)
                buffer = _buffer;
        }
    // otherwise if a file is selected in OPEN_DIALOG or
    // SAVE_DIALOG mode, just let the listener(s)
    // handle it
    }
    if (buffer != null) {
        switch(mode) {
            case M_OPEN:
                view.setBuffer(buffer);
                break;
            case M_OPEN_NEW_VIEW:
                jEdit.newView(view, buffer, false);
                break;
            case M_OPEN_NEW_PLAIN_VIEW:
                jEdit.newView(view, buffer, true);
                break;
            case M_OPEN_NEW_SPLIT:
                view.splitHorizontally().setBuffer(buffer);
                break;
        }
    }
    Object[] listeners = listenerList.getListenerList();
    for (int i = 0; i < listeners.length; i++) {
        if (listeners[i] == BrowserListener.class) {
            BrowserListener l = (BrowserListener) listeners[i + 1];
            l.filesActivated(this, selectedFiles);
        }
    }
}