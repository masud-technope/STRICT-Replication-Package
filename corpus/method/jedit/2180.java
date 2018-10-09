private final int jjMoveStringLiteralDfa5_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(3, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(4, active0, active1, active2);
        return 5;
    }
    switch(curChar) {
        case 95:
            return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x2000000000000L, active2, 0x2L);
        case 97:
            return jjMoveStringLiteralDfa6_0(active0, 0xc00L, active1, 0x800000000000000L, active2, 0L);
        case 99:
            if ((active0 & 0x200000000000L) != 0L)
                return jjStartNfaWithStates_0(5, 45, 35);
            else if ((active0 & 0x1000000000000L) != 0L)
                return jjStartNfaWithStates_0(5, 48, 35);
            return jjMoveStringLiteralDfa6_0(active0, 0x100000000000L, active1, 0L, active2, 0L);
        case 100:
            return jjMoveStringLiteralDfa6_0(active0, 0x2000000L, active1, 0L, active2, 0L);
        case 101:
            if ((active0 & 0x400000L) != 0L)
                return jjStartNfaWithStates_0(5, 22, 35);
            else if ((active0 & 0x8000000000L) != 0L)
                return jjStartNfaWithStates_0(5, 39, 35);
            break;
        case 102:
            return jjMoveStringLiteralDfa6_0(active0, 0x2000000000L, active1, 0L, active2, 0L);
        case 103:
            return jjMoveStringLiteralDfa6_0(active0, 0x40000000000L, active1, 0L, active2, 0L);
        case 104:
            if ((active0 & 0x4000000000000L) != 0L)
                return jjStartNfaWithStates_0(5, 50, 35);
            break;
        case 105:
            return jjMoveStringLiteralDfa6_0(active0, 0x410000000000000L, active1, 0x280000000000L, active2, 0L);
        case 108:
            return jjMoveStringLiteralDfa6_0(active0, 0x10100000L, active1, 0L, active2, 0L);
        case 109:
            return jjMoveStringLiteralDfa6_0(active0, 0x200000000L, active1, 0L, active2, 0L);
        case 110:
            if ((active0 & 0x400000000000L) != 0L)
                return jjStartNfaWithStates_0(5, 46, 35);
            return jjMoveStringLiteralDfa6_0(active0, 0x800080000L, active1, 0L, active2, 0L);
        case 114:
            return jjMoveStringLiteralDfa6_0(active0, 0x8000000000000L, active1, 0L, active2, 0L);
        case 115:
            if ((active0 & 0x40000000000000L) != 0L)
                return jjStartNfaWithStates_0(5, 54, 35);
            return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x2000000000000000L, active2, 0L);
        case 116:
            if ((active0 & 0x400000000L) != 0L)
                return jjStartNfaWithStates_0(5, 34, 35);
            return jjMoveStringLiteralDfa6_0(active0, 0x2080000000000L, active1, 0x28000000000000L, active2, 0x28L);
        default:
            break;
    }
    return jjStartNfa_0(4, active0, active1, active2);
}