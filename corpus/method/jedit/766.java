//}}}
//{{{ filesSelected() method
void filesSelected() {
    VFSFile[] selectedFiles = browserView.getSelectedFiles();
    if (mode == BROWSER) {
        for (VFSFile file : selectedFiles) {
            Buffer buffer = jEdit.getBuffer(file.getPath());
            if (buffer != null && view != null)
                view.setBuffer(buffer);
        }
    }
    Object[] listeners = listenerList.getListenerList();
    for (int i = 0; i < listeners.length; i++) {
        if (listeners[i] == BrowserListener.class) {
            BrowserListener l = (BrowserListener) listeners[i + 1];
            l.filesSelected(this, selectedFiles);
        }
    }
}