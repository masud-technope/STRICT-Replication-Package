//}}}
//{{{ remove() method
public void remove(int start, int len) {
    moveGapStart(start);
    length -= len;
}