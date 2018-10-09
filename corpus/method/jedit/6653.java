//}}}
//{{{ setBuffer() method
void setBuffer(JEditBuffer buffer) {
    this.buffer = buffer;
    lastScreenLine = lastScreenLineP = -1;
}