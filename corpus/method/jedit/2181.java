private final int jjMoveStringLiteralDfa8_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(6, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(7, active0, active1, active2);
        return 8;
    }
    switch(curChar) {
        case 95:
            return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0x280000000000L, active2, 0L);
        case 100:
            if ((active0 & 0x100000000000L) != 0L)
                return jjStartNfaWithStates_0(8, 44, 35);
            break;
        case 101:
            if ((active0 & 0x2000000000L) != 0L)
                return jjStartNfaWithStates_0(8, 37, 35);
            break;
        case 103:
            return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0x2000000000000000L, active2, 0L);
        case 104:
            return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0x8000000000000L, active2, 0x8L);
        case 105:
            return jjMoveStringLiteralDfa9_0(active0, 0x8000000000000L, active1, 0x802000000000000L, active2, 0x2L);
        case 110:
            return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0x20000000000000L, active2, 0x20L);
        case 111:
            return jjMoveStringLiteralDfa9_0(active0, 0x800000000L, active1, 0L, active2, 0L);
        case 116:
            if ((active0 & 0x10000000000000L) != 0L)
                return jjStartNfaWithStates_0(8, 52, 35);
            return jjMoveStringLiteralDfa9_0(active0, 0x200000000L, active1, 0L, active2, 0L);
        default:
            break;
    }
    return jjStartNfa_0(7, active0, active1, active2);
}