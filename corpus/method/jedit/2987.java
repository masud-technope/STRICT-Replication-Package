//}}}
//{{{ handleBufferUpdate() method
@EBHandler
public void handleBufferUpdate(BufferUpdate msg) {
    Buffer _buffer = msg.getBuffer();
    if (msg.getWhat() == BufferUpdate.CREATED) {
        if (bufferSwitcher != null)
            bufferSwitcher.updateBufferList();
        /* When closing the last buffer, the BufferUpdate.CLOSED
			 * handler doesn't call setBuffer(), because null buffers
			 * are not supported. Instead, it waits for the subsequent
			 * 'Untitled' file creation. */
        if (buffer.isClosed()) {
            // since recentBuffer will be set to the one that
            // was closed
            recentBuffer = null;
        }
    } else if (msg.getWhat() == BufferUpdate.CLOSED) {
        if (bufferSwitcher != null)
            bufferSwitcher.updateBufferList();
        if (_buffer == buffer) {
            // The closed buffer is the current buffer
            Buffer newBuffer = recentBuffer != null ? recentBuffer : _buffer.getPrev();
            if (newBuffer != null && !newBuffer.isClosed()) {
                setBuffer(newBuffer);
                recentBuffer = newBuffer.getPrev();
            }
        } else if (_buffer == recentBuffer)
            recentBuffer = null;
        Buffer closedBuffer = msg.getBuffer();
        if (closedBuffer.isUntitled()) {
            // the buffer was a new file so I do not need to keep it's informations
            caretsForPath.remove(closedBuffer.getPath());
        }
    } else if (msg.getWhat() == BufferUpdate.LOAD_STARTED) {
        if (_buffer == buffer) {
            textArea.setCaretPosition(0);
            textArea.getPainter().repaint();
        }
    } else if (msg.getWhat() == BufferUpdate.LOADED) {
        if (_buffer == buffer) {
            textArea.repaint();
            if (bufferSwitcher != null)
                bufferSwitcher.updateBufferList();
            if (view.getEditPane() == this) {
                StatusBar status = view.getStatus();
                status.updateCaretStatus();
                status.updateBufferStatus();
                status.updateMiscStatus();
            }
            loadCaretInfo();
        }
    } else if (msg.getWhat() == BufferUpdate.DIRTY_CHANGED) {
        if (_buffer == buffer && bufferSwitcher != null) {
            if (buffer.isDirty())
                bufferSwitcher.repaint();
            else
                bufferSwitcher.updateBufferList();
        }
    } else if (msg.getWhat() == BufferUpdate.MARKERS_CHANGED) {
        if (_buffer == buffer)
            textArea.getGutter().repaint();
    } else if (msg.getWhat() == BufferUpdate.PROPERTIES_CHANGED) {
        if (_buffer == buffer && buffer.isLoaded()) {
            textArea.propertiesChanged();
            if (view.getEditPane() == this)
                view.getStatus().updateBufferStatus();
        }
    } else if (msg.getWhat() == BufferUpdate.SAVED && _buffer == buffer) {
        textArea.propertiesChanged();
    }
}