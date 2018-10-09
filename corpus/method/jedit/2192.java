private final int jjMoveStringLiteralDfa18_0(long old1, long active1, long old2, long active2) {
    if (((active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(16, 0L, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(17, 0L, active1, active2);
        return 18;
    }
    switch(curChar) {
        case 105:
            return jjMoveStringLiteralDfa19_0(active1, 0x20000000000000L, active2, 0x20L);
        case 110:
            if ((active2 & 0x8L) != 0L)
                return jjStopAtPos(18, 131);
            break;
        default:
            break;
    }
    return jjStartNfa_0(17, 0L, active1, active2);
}