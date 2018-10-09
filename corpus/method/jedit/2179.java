private final int jjMoveStringLiteralDfa6_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(4, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(5, active0, active1, active2);
        return 6;
    }
    switch(curChar) {
        case 95:
            return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x28000000000000L, active2, 0x28L);
        case 97:
            return jjMoveStringLiteralDfa7_0(active0, 0x2000000000L, active1, 0L, active2, 0L);
        case 99:
            return jjMoveStringLiteralDfa7_0(active0, 0x800000400L, active1, 0L, active2, 0L);
        case 101:
            if ((active0 & 0x40000000000L) != 0L)
                return jjStartNfaWithStates_0(6, 42, 35);
            else if ((active0 & 0x80000000000L) != 0L)
                return jjStartNfaWithStates_0(6, 43, 35);
            return jjMoveStringLiteralDfa7_0(active0, 0x10000200000000L, active1, 0L, active2, 0L);
        case 102:
            return jjMoveStringLiteralDfa7_0(active0, 0x2000000000000L, active1, 0L, active2, 0L);
        case 108:
            return jjMoveStringLiteralDfa7_0(active0, 0x400000000000000L, active1, 0L, active2, 0L);
        case 110:
            if ((active0 & 0x800L) != 0L)
                return jjStartNfaWithStates_0(6, 11, 35);
            break;
        case 111:
            return jjMoveStringLiteralDfa7_0(active0, 0x8000000000000L, active1, 0L, active2, 0L);
        case 115:
            if ((active0 & 0x2000000L) != 0L)
                return jjStartNfaWithStates_0(6, 25, 35);
            return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x2802280000000000L, active2, 0x2L);
        case 116:
            if ((active0 & 0x100000L) != 0L)
                return jjStartNfaWithStates_0(6, 20, 35);
            return jjMoveStringLiteralDfa7_0(active0, 0x100000000000L, active1, 0L, active2, 0L);
        case 117:
            return jjMoveStringLiteralDfa7_0(active0, 0x80000L, active1, 0L, active2, 0L);
        case 121:
            if ((active0 & 0x10000000L) != 0L)
                return jjStartNfaWithStates_0(6, 28, 35);
            break;
        default:
            break;
    }
    return jjStartNfa_0(5, active0, active1, active2);
}