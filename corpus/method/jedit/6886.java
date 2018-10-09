//}}}
//{{{ isScreenLineCountValid() method
boolean isScreenLineCountValid(int line) {
    if (screenLines == null || line < 0 || line >= screenLines.length)
        return false;
    return screenLines[line] > 0;
}