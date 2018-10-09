private final int jjMoveStringLiteralDfa4_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(2, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(3, active0, active1, active2);
        return 4;
    }
    switch(curChar) {
        case 95:
            return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x800000000000000L, active2, 0L);
        case 97:
            return jjMoveStringLiteralDfa5_0(active0, 0xc0800000000L, active1, 0x2000000000000000L, active2, 0L);
        case 99:
            return jjMoveStringLiteralDfa5_0(active0, 0x6000000000000L, active1, 0L, active2, 0L);
        case 101:
            if ((active0 & 0x4000000L) != 0L)
                return jjStartNfaWithStates_0(4, 26, 35);
            else if ((active0 & 0x800000000000000L) != 0L)
                return jjStartNfaWithStates_0(4, 59, 35);
            return jjMoveStringLiteralDfa5_0(active0, 0x100200000800L, active1, 0L, active2, 0L);
        case 104:
            if ((active0 & 0x10000L) != 0L)
                return jjStartNfaWithStates_0(4, 16, 35);
            return jjMoveStringLiteralDfa5_0(active0, 0x8000000000000L, active1, 0x28000000000000L, active2, 0x28L);
        case 105:
            return jjMoveStringLiteralDfa5_0(active0, 0x1200000080000L, active1, 0L, active2, 0L);
        case 107:
            if ((active0 & 0x1000L) != 0L)
                return jjStartNfaWithStates_0(4, 12, 35);
            break;
        case 108:
            if ((active0 & 0x8000000L) != 0L) {
                jjmatchedKind = 27;
                jjmatchedPos = 4;
            }
            return jjMoveStringLiteralDfa5_0(active0, 0x10400000L, active1, 0L, active2, 0L);
        case 110:
            return jjMoveStringLiteralDfa5_0(active0, 0x2000000L, active1, 0L, active2, 0L);
        case 113:
            if ((active1 & 0x10000000L) != 0L)
                return jjStopAtPos(4, 92);
            else if ((active1 & 0x40000000L) != 0L)
                return jjStopAtPos(4, 94);
            break;
        case 114:
            return jjMoveStringLiteralDfa5_0(active0, 0x402400000400L, active1, 0L, active2, 0L);
        case 115:
            if ((active0 & 0x2000L) != 0L)
                return jjStartNfaWithStates_0(4, 13, 35);
            return jjMoveStringLiteralDfa5_0(active0, 0x10000000000000L, active1, 0L, active2, 0L);
        case 116:
            if ((active0 & 0x40000L) != 0L)
                return jjStartNfaWithStates_0(4, 18, 35);
            else if ((active0 & 0x20000000L) != 0L)
                return jjStartNfaWithStates_0(4, 29, 35);
            else if ((active0 & 0x800000000000L) != 0L)
                return jjStartNfaWithStates_0(4, 47, 35);
            return jjMoveStringLiteralDfa5_0(active0, 0x400000000000000L, active1, 0x2000000000000L, active2, 0x2L);
        case 117:
            return jjMoveStringLiteralDfa5_0(active0, 0x100000L, active1, 0L, active2, 0L);
        case 118:
            return jjMoveStringLiteralDfa5_0(active0, 0x8000000000L, active1, 0L, active2, 0L);
        case 119:
            if ((active0 & 0x20000000000000L) != 0L) {
                jjmatchedKind = 53;
                jjmatchedPos = 4;
            }
            return jjMoveStringLiteralDfa5_0(active0, 0x40000000000000L, active1, 0x280000000000L, active2, 0L);
        default:
            break;
    }
    return jjStartNfa_0(3, active0, active1, active2);
}