private final int jjMoveStringLiteralDfa10_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(8, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(9, active0, active1, active2);
        return 10;
    }
    switch(curChar) {
        case 101:
            return jjMoveStringLiteralDfa11_0(active0, 0x8000000000000L, active1, 0L, active2, 0L);
        case 102:
            return jjMoveStringLiteralDfa11_0(active0, 0L, active1, 0x8000000000000L, active2, 0x8L);
        case 105:
            return jjMoveStringLiteralDfa11_0(active0, 0L, active1, 0x20000000000000L, active2, 0x20L);
        case 110:
            if ((active1 & 0x800000000000000L) != 0L)
                return jjStopAtPos(10, 123);
            return jjMoveStringLiteralDfa11_0(active0, 0L, active1, 0x80000000000L, active2, 0L);
        case 114:
            if ((active1 & 0x200000000000L) != 0L)
                return jjStopAtPos(10, 109);
            break;
        case 116:
            if ((active1 & 0x2000000000000L) != 0L) {
                jjmatchedKind = 113;
                jjmatchedPos = 10;
            }
            return jjMoveStringLiteralDfa11_0(active0, 0L, active1, 0L, active2, 0x2L);
        default:
            break;
    }
    return jjStartNfa_0(9, active0, active1, active2);
}