private final int jjMoveStringLiteralDfa14_0(long old1, long active1, long old2, long active2) {
    if (((active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(12, 0L, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(13, 0L, active1, active2);
        return 14;
    }
    switch(curChar) {
        case 100:
            return jjMoveStringLiteralDfa15_0(active1, 0x20000000000000L, active2, 0x20L);
        case 115:
            return jjMoveStringLiteralDfa15_0(active1, 0L, active2, 0xaL);
        default:
            break;
    }
    return jjStartNfa_0(13, 0L, active1, active2);
}