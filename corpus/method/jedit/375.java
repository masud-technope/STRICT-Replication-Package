private void hbAssignCodes(int[] code, char[] length, int minLen, int maxLen, int alphaSize) {
    int n;
    int vec;
    int i;
    vec = 0;
    for (n = minLen; n <= maxLen; n++) {
        for (i = 0; i < alphaSize; i++) {
            if (length[i] == n) {
                code[i] = vec;
                vec++;
            }
        }
        ;
        vec <<= 1;
    }
}