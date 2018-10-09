//}}}
//{{{ ensureCapacity() method
private void ensureCapacity(int capacity) {
    if (capacity >= text.length) {
        int gapEndOld = gapEnd();
        char[] textN = new char[capacity * 2];
        System.arraycopy(text, 0, textN, 0, text.length);
        text = textN;
        int gapEndNew = gapEnd();
        System.arraycopy(text, gapEndOld, text, gapEndNew, text.length - gapEndNew);
    }
}