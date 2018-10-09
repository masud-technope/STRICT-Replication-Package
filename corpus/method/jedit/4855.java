//{{{ getNextUntitledBufferId() method
public static int getNextUntitledBufferId() {
    int untitledCount = 0;
    Buffer buffer = buffersFirst;
    while (buffer != null) {
        if (buffer.getName().startsWith("Untitled-")) {
            try {
                untitledCount = Math.max(untitledCount, Integer.parseInt(buffer.getName().substring(9)));
            } catch (NumberFormatException nf) {
            }
        }
        buffer = buffer.next;
    }
    return untitledCount + 1;
}