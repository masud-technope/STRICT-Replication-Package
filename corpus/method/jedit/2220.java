private final int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(1, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(2, active0, active1, active2);
        return 3;
    }
    switch(curChar) {
        case 61:
            if ((active2 & 0x10L) != 0L)
                return jjStopAtPos(3, 132);
            break;
        case 95:
            return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x2000000000000000L, active2, 0L);
        case 97:
            return jjMoveStringLiteralDfa4_0(active0, 0x400000038101000L, active1, 0L, active2, 0L);
        case 98:
            return jjMoveStringLiteralDfa4_0(active0, 0x400000L, active1, 0L, active2, 0L);
        case 99:
            return jjMoveStringLiteralDfa4_0(active0, 0x8000000010000L, active1, 0L, active2, 0L);
        case 100:
            if ((active0 & 0x200000000000000L) != 0L)
                return jjStartNfaWithStates_0(3, 57, 35);
            else if ((active1 & 0x800000000L) != 0L) {
                jjmatchedKind = 99;
                jjmatchedPos = 3;
            }
            return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x800000000000000L, active2, 0L);
        case 101:
            if ((active0 & 0x4000L) != 0L)
                return jjStartNfaWithStates_0(3, 14, 35);
            else if ((active0 & 0x8000L) != 0L)
                return jjStartNfaWithStates_0(3, 15, 35);
            else if ((active0 & 0x800000L) != 0L)
                return jjStartNfaWithStates_0(3, 23, 35);
            else if ((active0 & 0x80000000000000L) != 0L)
                return jjStartNfaWithStates_0(3, 55, 35);
            return jjMoveStringLiteralDfa4_0(active0, 0x2002000000L, active1, 0x50000000L, active2, 0L);
        case 102:
            return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x2000000000000L, active2, 0x2L);
        case 103:
            if ((active0 & 0x4000000000L) != 0L)
                return jjStartNfaWithStates_0(3, 38, 35);
            return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x28000000000000L, active2, 0x28L);
        case 105:
            return jjMoveStringLiteralDfa4_0(active0, 0x2008000000000L, active1, 0L, active2, 0L);
        case 107:
            return jjMoveStringLiteralDfa4_0(active0, 0x40000000000L, active1, 0L, active2, 0L);
        case 108:
            if ((active0 & 0x20000000000L) != 0L)
                return jjStartNfaWithStates_0(3, 41, 35);
            return jjMoveStringLiteralDfa4_0(active0, 0x800200200000800L, active1, 0L, active2, 0L);
        case 109:
            if ((active0 & 0x1000000L) != 0L)
                return jjStartNfaWithStates_0(3, 24, 35);
            break;
        case 110:
            return jjMoveStringLiteralDfa4_0(active0, 0x10000000000000L, active1, 0L, active2, 0L);
        case 111:
            if ((active0 & 0x80000000L) != 0L)
                return jjStartNfaWithStates_0(3, 31, 35);
            return jjMoveStringLiteralDfa4_0(active0, 0x60000400000000L, active1, 0L, active2, 0L);
        case 114:
            if ((active0 & 0x20000L) != 0L)
                return jjStartNfaWithStates_0(3, 17, 35);
            return jjMoveStringLiteralDfa4_0(active0, 0x800000000000L, active1, 0L, active2, 0L);
        case 115:
            return jjMoveStringLiteralDfa4_0(active0, 0x4042000L, active1, 0L, active2, 0L);
        case 116:
            return jjMoveStringLiteralDfa4_0(active0, 0x5100800080400L, active1, 0x280000000000L, active2, 0L);
        case 117:
            return jjMoveStringLiteralDfa4_0(active0, 0x400000000000L, active1, 0L, active2, 0L);
        case 118:
            return jjMoveStringLiteralDfa4_0(active0, 0x80000000000L, active1, 0L, active2, 0L);
        default:
            break;
    }
    return jjStartNfa_0(2, active0, active1, active2);
}