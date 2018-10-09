//{{{ getBuffer() method
public Buffer getBuffer(View view) {
    if (buffer == null)
        buffer = jEdit.openFile(view, path);
    return buffer;
}