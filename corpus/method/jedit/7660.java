public static boolean regionMatches(CharSequence seq, int toff, CharSequence other, int ooff, int len) {
    if (toff < 0 || ooff < 0 || len < 0)
        return false;
    boolean ret = true;
    for (int i = 0; i < len; i++) {
        char c1;
        if (i + toff < seq.length())
            c1 = seq.charAt(i + toff);
        else {
            ret = false;
            break;
        }
        char c2;
        if (i + ooff < other.length())
            c2 = other.charAt(i + ooff);
        else {
            ret = false;
            break;
        }
        if (c1 != c2) {
            ret = false;
            break;
        }
    }
    return ret;
}