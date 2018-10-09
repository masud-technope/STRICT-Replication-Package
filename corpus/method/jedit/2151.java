private final boolean jj_2_4(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
        return !jj_3_4();
    } catch (LookaheadSuccess ls) {
        return true;
    }
}