//}}}
//{{{ addBufferAt() method
/**
	 * Internal use only, use
	 * {@link org.gjt.sp.jedit.bufferset.BufferSetManager#addBuffer(org.gjt.sp.jedit.View, org.gjt.sp.jedit.Buffer)}
	 * or
	 * {@link org.gjt.sp.jedit.bufferset.BufferSetManager#addBuffer(org.gjt.sp.jedit.EditPane, org.gjt.sp.jedit.Buffer)}
	 * @param buffer the buffer to be added
	 * @param position the position where it must be added or -1 if we don't care
	 */
public void addBufferAt(Buffer buffer, int position) {
    Log.log(Log.DEBUG, this, hashCode() + " addBufferAt(" + buffer + ',' + position + ')');
    Buffer untitledBuffer = null;
    synchronized (buffers) {
        if (buffers.size() == 1) {
            Buffer buf = buffers.get(0);
            if (buf.isUntitled() && !buf.isDirty()) {
                untitledBuffer = buf;
            }
        }
        if (sorter != null) {
            if (buffers.contains(buffer))
                return;
            buffers.add(buffer);
            Collections.sort(buffers, sorter);
            position = buffers.indexOf(buffer);
        } else {
            int oldPos = buffers.indexOf(buffer);
            if (oldPos != -1) {
                if (position == -1) {
                    return;
                }
                moveBuffer(oldPos, position);
                return;
            }
            int size = buffers.size();
            if (position == -1 || position > size) {
                position = size;
            }
            buffers.add(position, buffer);
        }
    }
    BufferSetListener[] listeners = this.listeners.getListeners(BufferSetListener.class);
    Log.log(Log.DEBUG, this, hashCode() + ": Buffer added " + buffer + " at " + position);
    for (BufferSetListener listener : listeners) {
        listener.bufferAdded(buffer, position);
    }
    // I don't like this reverse control
    if (untitledBuffer != null) {
        jEdit.getBufferSetManager().removeBuffer(this, untitledBuffer);
    }
}