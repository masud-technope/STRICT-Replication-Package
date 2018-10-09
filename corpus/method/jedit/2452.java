//}}}
//{{{ insert() methods
public void insert(int start, String str) {
    int len = str.length();
    prepareGapForInsertion(start, len);
    str.getChars(0, len, text, start);
    gapStart += len;
    length += len;
}