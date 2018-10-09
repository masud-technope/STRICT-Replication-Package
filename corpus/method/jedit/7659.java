public static boolean startsWith(CharSequence seq, String str) {
    boolean ret = true;
    for (int i = 0; i < str.length(); i++) {
        if (i >= seq.length() || seq.charAt(i) != str.charAt(i)) {
            ret = false;
            break;
        }
    }
    return ret;
}