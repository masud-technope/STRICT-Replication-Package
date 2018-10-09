//}}}
//{{{ bufferClosed() method
public static void bufferClosed(JEditBuffer buffer) {
    bufferMap.remove(buffer);
}