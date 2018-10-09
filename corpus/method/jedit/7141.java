//}}}
//{{{ deletePrevCodePoint() method
// Delete a code point.
// This is the behavior of backward removal on Windows Notepad.
private void deletePrevCodePoint(int offset) {
    assert offset > 0;
    int length = 1;
    if (offset >= 2) {
        Segment prevText = new Segment();
        buffer.getText(offset - 1, 1, prevText);
        char prevCodeUnit = prevText.array[prevText.offset];
        if (Character.isLowSurrogate(prevCodeUnit)) {
            buffer.getText(offset - 2, 1, prevText);
            prevCodeUnit = prevText.array[prevText.offset];
            if (Character.isHighSurrogate(prevCodeUnit)) {
                length = 2;
            }
        }
    }
    buffer.remove(offset - length, length);
}