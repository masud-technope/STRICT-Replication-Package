private final boolean jj_2_16(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
        return !jj_3_16();
    } catch (LookaheadSuccess ls) {
        return true;
    }
}