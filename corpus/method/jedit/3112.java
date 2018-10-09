public void updateBufferList() {
    // if the buffer count becomes 0, then it is guaranteed to
    // become 1 very soon, so don't do anything in that case.
    final BufferSet bufferSet = editPane.getBufferSet();
    if (bufferSet.size() == 0)
        return;
    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            updating = true;
            setMaximumRowCount(jEdit.getIntegerProperty("bufferSwitcher.maxRowCount", 10));
            Buffer[] buffers = bufferSet.getAllBuffers();
            if (jEdit.getBooleanProperty("bufferswitcher.sortBuffers", true)) {
                Arrays.sort(buffers, new Comparator<Buffer>() {

                    public int compare(Buffer a, Buffer b) {
                        if (jEdit.getBooleanProperty("bufferswitcher.sortByName", true))
                            return a.getName().toLowerCase().compareTo(b.getName().toLowerCase());
                        else
                            return a.getPath().toLowerCase().compareTo(b.getPath().toLowerCase());
                    }
                });
            }
            setModel(new DefaultComboBoxModel<Buffer>(buffers));
            // FIXME: editPane.getBuffer() returns wrong buffer (old buffer) after last non-untitled buffer close.
            // When the only non-untitled (last) buffer is closed a new untitled buffer is added to BufferSet
            // directly from BufferSetManager (@see BufferSetManager.bufferRemoved() and BufferSetManager.addBuffer())
            // This triggers EditPane.bufferAdded() -> bufferSwitcher.updateBufferList() bypassing setting EditPane's
            // buffer object reference to a new created untitled buffer.
            // This is why here editPane.getBuffer() returns wrong previous already closed buffer in that case.
            setSelectedItem(editPane.getBuffer());
            addDnD();
            updating = false;
        }
    };
    ThreadUtilities.runInDispatchThread(runnable);
}