private final int jjMoveStringLiteralDfa12_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(10, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(11, 0L, active1, active2);
        return 12;
    }
    switch(curChar) {
        case 95:
            return jjMoveStringLiteralDfa13_0(active1, 0L, active2, 0x8L);
        case 97:
            return jjMoveStringLiteralDfa13_0(active1, 0L, active2, 0x2L);
        case 110:
            return jjMoveStringLiteralDfa13_0(active1, 0x20000000000000L, active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(11, 0L, active1, active2);
}