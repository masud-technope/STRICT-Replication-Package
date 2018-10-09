//{{{ compareChars() method
/**
	 * Compares two chars.
	 * should this be public?
	 * @param ch1 the first char
	 * @param ch2 the second char
	 * @param ignoreCase true if you want to ignore case
	 */
private static boolean compareChars(char ch1, char ch2, boolean ignoreCase) {
    if (ignoreCase)
        return Character.toUpperCase(ch1) == Character.toUpperCase(ch2);
    else
        return ch1 == ch2;
}