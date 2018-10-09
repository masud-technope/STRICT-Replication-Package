//}}}
//{{{ removeBuffer() method
void removeBuffer(Buffer buffer) {
    int index;
    synchronized (buffers) {
        index = buffers.indexOf(buffer);
        if (index == -1)
            return;
        buffers.remove(index);
    }
    BufferSetListener[] listeners = this.listeners.getListeners(BufferSetListener.class);
    Log.log(Log.DEBUG, this, hashCode() + ": Buffer removed " + buffer);
    for (BufferSetListener listener : listeners) {
        listener.bufferRemoved(buffer, index);
    }
}