//}}}
//{{{ dispose() method
void dispose() {
    if (buffer != null) {
        buffer.removeBufferListener(bufferListener);
        buffer = null;
    }
}