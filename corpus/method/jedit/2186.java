private final int jjMoveStringLiteralDfa9_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(7, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(8, active0, active1, active2);
        return 9;
    }
    switch(curChar) {
        case 97:
            return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0x80000000000L, active2, 0L);
        case 102:
            if ((active0 & 0x800000000L) != 0L)
                return jjStartNfaWithStates_0(9, 35, 35);
            return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0x2000000000000L, active2, 0x2L);
        case 103:
            return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0x800000000000000L, active2, 0L);
        case 105:
            return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0x8000000000000L, active2, 0x8L);
        case 110:
            if ((active1 & 0x2000000000000000L) != 0L)
                return jjStopAtPos(9, 125);
            break;
        case 111:
            return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0x200000000000L, active2, 0L);
        case 115:
            if ((active0 & 0x200000000L) != 0L)
                return jjStartNfaWithStates_0(9, 33, 35);
            return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0x20000000000000L, active2, 0x20L);
        case 122:
            return jjMoveStringLiteralDfa10_0(active0, 0x8000000000000L, active1, 0L, active2, 0L);
        default:
            break;
    }
    return jjStartNfa_0(8, active0, active1, active2);
}