//}}}
//{{{ getText() methods
public String getText(int start, int len) {
    if (start >= gapStart)
        return new String(text, start + gapLength(), len);
    else if (start + len <= gapStart)
        return new String(text, start, len);
    else {
        return new String(text, start, gapStart - start).concat(new String(text, gapEnd(), start + len - gapStart));
    }
}