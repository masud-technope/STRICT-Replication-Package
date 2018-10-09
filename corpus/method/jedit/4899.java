//}}}
//{{{ removeBufferFromList() method
private static void removeBufferFromList(Buffer buffer) {
    synchronized (bufferListLock) {
        bufferCount--;
        String path = buffer.getPath();
        if (OperatingSystem.isCaseInsensitiveFS())
            path = path.toLowerCase();
        bufferHash.remove(path);
        if (buffer == buffersFirst && buffer == buffersLast) {
            buffersFirst = buffersLast = null;
            return;
        }
        if (buffer == buffersFirst) {
            buffersFirst = buffer.next;
            buffer.next.prev = null;
        } else {
            if (buffer.prev != null)
                buffer.prev.next = buffer.next;
        }
        if (buffer == buffersLast) {
            buffersLast = buffersLast.prev;
            buffer.prev.next = null;
        } else {
            if (buffer.next != null)
                buffer.next.prev = buffer.prev;
        }
        // fixes the hang that can occur if we 'save as' to a new
        // filename which requires re-sorting
        buffer.next = buffer.prev = null;
    }
}