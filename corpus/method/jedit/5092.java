public static String getLongestPrefix(List<String> str, boolean ignoreCase) {
    if (str.isEmpty())
        return "";
    int prefixLength = 0;
    loop: for (; ; ) {
        String s = str.get(0);
        if (prefixLength >= s.length())
            break loop;
        char ch = s.charAt(prefixLength);
        for (int i = 1; i < str.size(); i++) {
            s = str.get(i);
            if (prefixLength >= s.length())
                break loop;
            if (!compareChars(s.charAt(prefixLength), ch, ignoreCase))
                break loop;
        }
        prefixLength++;
    }
    return str.get(0).substring(0, prefixLength);
}