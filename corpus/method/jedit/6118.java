//}}}
//{{{ generateSuffixArray() method
/*
	 *  XXX: hairy code that is basically just a functional(?) port of some
	 *  other code i barely understood
	 */
private int[] generateSuffixArray(boolean reverse) {
    int m = pattern.length;
    int j = m + 1;
    int[] suffix = new int[j];
    int[] tmp = new int[j];
    tmp[m] = j;
    for (int i = m; i > 0; --i) {
        while (j <= m && pattern[reverse ? pattern_end - i + 1 : i - 1] != pattern[reverse ? pattern_end - j + 1 : j - 1]) {
            if (suffix[j] == 0) {
                suffix[j] = j - i;
            }
            j = tmp[j];
        }
        tmp[i - 1] = --j;
    }
    int k = tmp[0];
    for (j = 0; j <= m; j++) {
        // original 0-th element
        if (j > 0) {
            suffix[j - 1] = (suffix[j] == 0) ? k : suffix[j];
        }
        if (j == k) {
            k = tmp[k];
        }
    }
    return suffix;
}