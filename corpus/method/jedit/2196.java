private final int jjMoveStringLiteralDfa20_0(long old1, long active1, long old2, long active2) {
    if (((active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(18, 0L, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(19, 0L, active1, active2);
        return 20;
    }
    switch(curChar) {
        case 116:
            if ((active1 & 0x20000000000000L) != 0L) {
                jjmatchedKind = 117;
                jjmatchedPos = 20;
            }
            return jjMoveStringLiteralDfa21_0(active1, 0L, active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(19, 0L, active1, active2);
}