private final int jjMoveStringLiteralDfa19_0(long old1, long active1, long old2, long active2) {
    if (((active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(17, 0L, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(18, 0L, active1, active2);
        return 19;
    }
    switch(curChar) {
        case 102:
            return jjMoveStringLiteralDfa20_0(active1, 0x20000000000000L, active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(18, 0L, active1, active2);
}