//}}}
//{{{ setBuffer() method
/**
	 * Sets the buffer this text area is editing.
	 * If you don't run a standalone textarea in jEdit please do not call this method -
	 * use {@link org.gjt.sp.jedit.EditPane#setBuffer(org.gjt.sp.jedit.Buffer)} instead.
	 * @param buffer The buffer
	 */
public void setBuffer(JEditBuffer buffer) {
    if (this.buffer == buffer)
        return;
    try {
        bufferChanging = true;
        boolean inCompoundEdit = false;
        if (this.buffer != null) {
            if (!this.buffer.isLoading())
                selectNone();
            caretLine = caret = caretScreenLine = 0;
            match = null;
            // is the current buffer performing a compoundEdit?
            inCompoundEdit = this.buffer.insideCompoundEdit();
            if (inCompoundEdit)
                this.buffer.endCompoundEdit();
        }
        // set new buffer
        this.buffer = buffer;
        // so open a compoundEdit for new buffer
        if (inCompoundEdit)
            this.buffer.beginCompoundEdit();
        chunkCache.setBuffer(buffer);
        gutter.setBuffer(buffer);
        propertiesChanged();
        if (displayManager != null) {
            displayManager.release();
        }
        displayManager = DisplayManager.getDisplayManager(buffer, this);
        displayManager.init();
        if (buffer.isLoading())
            updateScrollBar();
        repaint();
        fireScrollEvent(true);
    } finally {
        bufferChanging = false;
    }
}