private final boolean jj_2_8(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
        return !jj_3_8();
    } catch (LookaheadSuccess ls) {
        return true;
    }
}