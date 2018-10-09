private void hbCreateDecodeTables(final int[] limit, final int[] base, final int[] perm, final char[] length, final int minLen, final int maxLen, final int alphaSize) {
    int pp = 0;
    for (int i = minLen; i <= maxLen; i++) {
        for (int j = 0; j < alphaSize; j++) {
            if (length[j] == i) {
                perm[pp] = j;
                pp++;
            }
        }
    }
    for (int i = 0; i < MAX_CODE_LEN; i++) {
        base[i] = 0;
    }
    for (int i = 0; i < alphaSize; i++) {
        base[length[i] + 1]++;
    }
    for (int i = 1; i < MAX_CODE_LEN; i++) {
        base[i] += base[i - 1];
    }
    for (int i = 0; i < MAX_CODE_LEN; i++) {
        limit[i] = 0;
    }
    int vec = 0;
    for (int i = minLen; i <= maxLen; i++) {
        vec += (base[i + 1] - base[i]);
        limit[i] = vec - 1;
        vec <<= 1;
    }
    for (int i = minLen + 1; i <= maxLen; i++) {
        base[i] = ((limit[i - 1] + 1) << 1) - base[i];
    }
}