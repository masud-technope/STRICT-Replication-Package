/**
	 * Sets the current buffer.
	 * @param buffer The buffer to edit.
	 * @param requestFocus true if the textarea should request focus, false otherwise
	 * @since jEdit 4.3pre6
	 */
public void setBuffer(@Nonnull final Buffer buffer, boolean requestFocus) {
    if (buffer == null)
        throw new NullPointerException("The buffer cannot be null");
    if (this.buffer == buffer)
        return;
    if (bufferSet.indexOf(buffer) == -1) {
        jEdit.getBufferSetManager().addBuffer(this, buffer);
    }
    //if(buffer.insideCompoundEdit())
    //	buffer.endCompoundEdit();
    EditBus.send(new BufferChanging(this, buffer));
    if (bufferSet.indexOf(this.buffer) != -1) {
        // when closing the last buffer of a bufferSet, the current buffer will still be the closed
        // buffer until a new empty buffer is created.
        // So if the current buffer is not anymore in the bufferSet, do not set the recentBuffer
        recentBuffer = this.buffer;
    }
    if (recentBuffer != null)
        saveCaretInfo();
    this.buffer = buffer;
    textArea.setBuffer(buffer);
    if (!init) {
        view.updateTitle();
        if (bufferSwitcher != null) {
            if (bufferSwitcher.getSelectedItem() != buffer)
                bufferSwitcher.setSelectedItem(buffer);
            bufferSwitcher.updateStyle(buffer);
        }
        EditBus.send(new EditPaneUpdate(this, EditPaneUpdate.BUFFER_CHANGED));
    }
    if (requestFocus) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                // only do this if we are the current edit pane
                if (view.getEditPane() == EditPane.this && (bufferSwitcher == null || !bufferSwitcher.isPopupVisible())) {
                    textArea.requestFocus();
                }
            }
        });
    }
    // BufferUpdate.LOADED. Otherwise, we don't need to wait for IO.
    if (!buffer.isLoading()) {
        ThreadUtilities.runInDispatchThread(new Runnable() {

            public void run() {
                // see bug #834338
                if (buffer == getBuffer())
                    loadCaretInfo();
                // This must happen after loadCaretInfo.
                // Otherwise caret is not restored properly.
                int check = jEdit.getIntegerProperty("checkFileStatus");
                if (jEdit.isStartupDone() && (check & GeneralOptionPane.checkFileStatus_focusBuffer) > 0)
                    jEdit.checkBufferStatus(view, true);
            }
        });
    }
}