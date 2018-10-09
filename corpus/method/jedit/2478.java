// Returns the width of leading whitespace in the given segment
// if it contains non-whitespace characters, or (-1) otherwise.
private int getLeadingWhitespaceWidth(Segment seg, int tabSize) {
    int offset = seg.offset;
    int count = seg.count;
    int whitespace = 0;
    for (int i = 0; i < count; i++) {
        switch(seg.array[offset + i]) {
            case ' ':
                whitespace++;
                break;
            case '\t':
                whitespace += (tabSize - whitespace % tabSize);
                break;
            default:
                return whitespace;
        }
    }
    return (-1);
}