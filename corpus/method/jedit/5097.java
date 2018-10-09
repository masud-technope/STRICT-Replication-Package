public static String getLongestPrefix(Object[] str, boolean ignoreCase) {
    if (str.length == 0)
        return "";
    int prefixLength = 0;
    String first = str[0].toString();
    loop: for (; ; ) {
        if (prefixLength >= first.length())
            break loop;
        char ch = first.charAt(prefixLength);
        for (int i = 1; i < str.length; i++) {
            String s = str[i].toString();
            if (prefixLength >= s.length())
                break loop;
            if (!compareChars(s.charAt(prefixLength), ch, ignoreCase))
                break loop;
        }
        prefixLength++;
    }
    return first.substring(0, prefixLength);
}