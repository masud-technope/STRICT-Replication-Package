//{{{ bufferClosed() method
void bufferClosed() {
    start = startPos.getOffset();
    end = endPos.getOffset();
    startPos = endPos = null;
//}}}
}