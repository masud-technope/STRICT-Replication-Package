private final boolean jj_2_2(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
        return !jj_3_2();
    } catch (LookaheadSuccess ls) {
        return true;
    }
}