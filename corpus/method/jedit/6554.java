//{{{ charArraysEqual() method
private static boolean charArraysEqual(char[] c1, char[] c2) {
    if (c1 == null)
        return c2 == null;
    // c1 is not null
    if (c2 == null)
        return false;
    if (c1.length != c2.length)
        return false;
    for (int i = 0; i < c1.length; i++) {
        if (c1[i] != c2[i])
            return false;
    }
    return true;
//}}}
}