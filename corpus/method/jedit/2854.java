//}}}
//{{{ getPreviousBuffer() method
public Buffer getPreviousBuffer(int index) {
    if (buffers.isEmpty())
        return null;
    if (buffers.size() < 2)
        return buffers.get(0);
    if (index <= 0)
        return buffers.get(buffers.size() - 1);
    return buffers.get(index - 1);
}