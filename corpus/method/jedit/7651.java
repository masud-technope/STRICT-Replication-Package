//}}}
//{{{ compareStrings() method
/**
	 * Compares two strings.<p>
	 *
	 * Unlike <code>String.compareTo()</code>,
	 * this method correctly recognizes and handles embedded numbers.
	 * For example, it places "My file 2" before "My file 10".<p>
	 *
	 * @param str1 The first string (maybe null)
	 * @param str2 The second string (maybe null)
	 * @param ignoreCase If true, case will be ignored
	 * @return negative If str1 &lt; str2, 0 if both are the same,
	 * positive if str1 &gt; str2 (null &lt; any non-null string, null = null)
	 * @since jEdit 4.3pre5
	 */
public static int compareStrings(String str1, String str2, boolean ignoreCase) {
    if (str1 == str2) {
        return 0;
    } else if (str1 == null) {
        return -1;
    } else if (str2 == null) {
        return 1;
    }
    char[] char1 = str1.toCharArray();
    char[] char2 = str2.toCharArray();
    int len = Math.min(char1.length, char2.length);
    for (int i = 0, j = 0; i < len && j < len; i++, j++) {
        char ch1 = char1[i];
        char ch2 = char2[j];
        if (Character.isDigit(ch1) && Character.isDigit(ch2) && ch1 != '0' && ch2 != '0') {
            int _i = i + 1;
            int _j = j + 1;
            for (; _i < char1.length; _i++) {
                if (!Character.isDigit(char1[_i])) {
                    //_i--;
                    break;
                }
            }
            for (; _j < char2.length; _j++) {
                if (!Character.isDigit(char2[_j])) {
                    //_j--;
                    break;
                }
            }
            int len1 = _i - i;
            int len2 = _j - j;
            if (len1 > len2)
                return 1;
            else if (len1 < len2)
                return -1;
            else {
                for (int k = 0; k < len1; k++) {
                    ch1 = char1[i + k];
                    ch2 = char2[j + k];
                    if (ch1 != ch2)
                        return ch1 - ch2;
                }
            }
            i = _i - 1;
            j = _j - 1;
        } else {
            if (ignoreCase) {
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
            }
            if (ch1 != ch2)
                return ch1 - ch2;
        }
    }
    return char1.length - char2.length;
}