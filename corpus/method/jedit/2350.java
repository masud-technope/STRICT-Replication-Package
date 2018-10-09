public static String maxCommonPrefix(String one, String two) {
    int i = 0;
    while (one.regionMatches(0, two, 0, i)) i++;
    return one.substring(0, i - 1);
}