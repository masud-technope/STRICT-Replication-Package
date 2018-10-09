private final boolean jj_2_5(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
        return !jj_3_5();
    } catch (LookaheadSuccess ls) {
        return true;
    }
}