private final int jjMoveStringLiteralDfa11_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(9, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(10, active0, active1, active2);
        return 11;
    }
    switch(curChar) {
        case 95:
            return jjMoveStringLiteralDfa12_0(active0, 0L, active1, 0L, active2, 0x2L);
        case 100:
            if ((active0 & 0x8000000000000L) != 0L)
                return jjStartNfaWithStates_0(11, 51, 35);
            else if ((active1 & 0x80000000000L) != 0L)
                return jjStopAtPos(11, 107);
            break;
        case 103:
            return jjMoveStringLiteralDfa12_0(active0, 0L, active1, 0x20000000000000L, active2, 0x20L);
        case 116:
            if ((active1 & 0x8000000000000L) != 0L) {
                jjmatchedKind = 115;
                jjmatchedPos = 11;
            }
            return jjMoveStringLiteralDfa12_0(active0, 0L, active1, 0L, active2, 0x8L);
        default:
            break;
    }
    return jjStartNfa_0(10, active0, active1, active2);
}