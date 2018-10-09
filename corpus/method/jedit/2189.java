private final int jjMoveStringLiteralDfa17_0(long old1, long active1, long old2, long active2) {
    if (((active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(15, 0L, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(16, 0L, active1, active2);
        return 17;
    }
    switch(curChar) {
        case 103:
            return jjMoveStringLiteralDfa18_0(active1, 0L, active2, 0x8L);
        case 104:
            return jjMoveStringLiteralDfa18_0(active1, 0x20000000000000L, active2, 0x20L);
        case 110:
            if ((active2 & 0x2L) != 0L)
                return jjStopAtPos(17, 129);
            break;
        default:
            break;
    }
    return jjStartNfa_0(16, 0L, active1, active2);
}