//}}}
//{{{ add() method
void add(String removed) {
    // in the kill ring
    if (indexOf(removed) != -1)
        return;
    // no duplicates, check for all-whitespace string
    boolean allWhitespace = true;
    for (int i = 0; i < removed.length(); i++) {
        if (!Character.isWhitespace(removed.charAt(i))) {
            allWhitespace = false;
            break;
        }
    }
    if (allWhitespace)
        return;
    ring[count] = removed;
    if (++count >= ring.length) {
        wrap = true;
        count = 0;
    }
}