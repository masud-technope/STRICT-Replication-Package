//}}}
//{{{ getAllBuffers() methods
public void getAllBuffers(BufferSetListener listener) {
    synchronized (buffers) {
        for (int i = 0; i < buffers.size(); i++) {
            Buffer buffer = buffers.get(i);
            Log.log(Log.DEBUG, this, hashCode() + ": Buffer added " + buffer + " at " + i);
            listener.bufferAdded(buffer, i);
        }
    }
}