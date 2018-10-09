private final boolean jj_2_12(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
        return !jj_3_12();
    } catch (LookaheadSuccess ls) {
        return true;
    }
}