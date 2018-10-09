//}}}
//{{{ setBuffer() method
void setBuffer(JEditBuffer newBuffer) {
    if (buffer != null)
        buffer.removeBufferListener(bufferListener);
    buffer = newBuffer;
    if (buffer != null)
        buffer.addBufferListener(bufferListener);
    updateLineNumberWidth();
}