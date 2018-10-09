//}}}
//{{{ moveBuffer() method
void moveBuffer(int oldPosition, int newPosition) {
    if (sorter != null) {
        // Buffers are sorted, do nothing
        return;
    }
    Buffer buffer;
    synchronized (buffers) {
        buffer = buffers.remove(oldPosition);
        int size = buffers.size();
        if (newPosition == -1 || newPosition > size) {
            newPosition = size;
        }
        buffers.add(newPosition, buffer);
    }
    BufferSetListener[] listeners = this.listeners.getListeners(BufferSetListener.class);
    Log.log(Log.DEBUG, this, hashCode() + ": Buffer moved " + buffer + " from " + oldPosition + " to " + newPosition);
    for (BufferSetListener listener : listeners) {
        listener.bufferMoved(buffer, oldPosition, newPosition);
    }
}