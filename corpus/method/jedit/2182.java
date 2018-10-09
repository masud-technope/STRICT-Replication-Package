private final int jjMoveStringLiteralDfa7_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(5, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(6, active0, active1, active2);
        return 7;
    }
    switch(curChar) {
        case 99:
            return jjMoveStringLiteralDfa8_0(active0, 0x2000000000L, active1, 0L, active2, 0L);
        case 101:
            if ((active0 & 0x80000L) != 0L)
                return jjStartNfaWithStates_0(7, 19, 35);
            else if ((active0 & 0x400000000000000L) != 0L)
                return jjStartNfaWithStates_0(7, 58, 35);
            return jjMoveStringLiteralDfa8_0(active0, 0x100800000000L, active1, 0x280000000000L, active2, 0L);
        case 104:
            return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x2000000000000L, active2, 0x2L);
        case 105:
            return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x2000000000000000L, active2, 0L);
        case 110:
            return jjMoveStringLiteralDfa8_0(active0, 0x18000200000000L, active1, 0L, active2, 0L);
        case 112:
            if ((active0 & 0x2000000000000L) != 0L)
                return jjStartNfaWithStates_0(7, 49, 35);
            break;
        case 115:
            return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x808000000000000L, active2, 0x8L);
        case 116:
            if ((active0 & 0x400L) != 0L)
                return jjStartNfaWithStates_0(7, 10, 35);
            break;
        case 117:
            return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x20000000000000L, active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(6, active0, active1, active2);
}