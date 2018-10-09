//{{{ bufferOpened() method
void bufferOpened() {
    startPos = buffer.createPosition(Math.min(buffer.getLength(), start));
    endPos = buffer.createPosition(Math.min(buffer.getLength(), end));
//}}}
}