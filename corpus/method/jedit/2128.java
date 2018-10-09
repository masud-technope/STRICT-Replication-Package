private final boolean jj_2_9(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
        return !jj_3_9();
    } catch (LookaheadSuccess ls) {
        return true;
    }
}