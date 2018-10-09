//}}}
//{{{ getNextBuffer() method
public Buffer getNextBuffer(int index) {
    if (buffers.isEmpty())
        return null;
    if (buffers.size() < 2)
        return buffers.get(buffers.size() - 1);
    if (index >= buffers.size() - 1)
        return buffers.get(0);
    return buffers.get(index + 1);
}