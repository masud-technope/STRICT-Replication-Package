private final int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(0, old0, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(1, active0, active1, active2);
        return 2;
    }
    switch(curChar) {
        case 61:
            if ((active2 & 0x1L) != 0L)
                return jjStopAtPos(2, 128);
            else if ((active2 & 0x4L) != 0L)
                return jjStopAtPos(2, 130);
            break;
        case 62:
            if ((active1 & 0x10000000000000L) != 0L) {
                jjmatchedKind = 116;
                jjmatchedPos = 2;
            }
            return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0L, active2, 0x10L);
        case 97:
            return jjMoveStringLiteralDfa3_0(active0, 0x11000000022000L, active1, 0L, active2, 0L);
        case 98:
            return jjMoveStringLiteralDfa3_0(active0, 0x200000000000L, active1, 0L, active2, 0L);
        case 99:
            return jjMoveStringLiteralDfa3_0(active0, 0x40000000000L, active1, 0L, active2, 0L);
        case 101:
            return jjMoveStringLiteralDfa3_0(active0, 0x1000L, active1, 0x2000000000000L, active2, 0x2L);
        case 102:
            return jjMoveStringLiteralDfa3_0(active0, 0x100000L, active1, 0L, active2, 0L);
        case 105:
            return jjMoveStringLiteralDfa3_0(active0, 0xa04080000000000L, active1, 0x28280000000000L, active2, 0x28L);
        case 108:
            return jjMoveStringLiteralDfa3_0(active0, 0x400020004000000L, active1, 0L, active2, 0L);
        case 110:
            return jjMoveStringLiteralDfa3_0(active0, 0x80040180c0000L, active1, 0x800000800000000L, active2, 0L);
        case 111:
            return jjMoveStringLiteralDfa3_0(active0, 0x900020000800L, active1, 0L, active2, 0L);
        case 112:
            return jjMoveStringLiteralDfa3_0(active0, 0x600000000L, active1, 0L, active2, 0L);
        case 114:
            if ((active0 & 0x40000000L) != 0L)
                return jjStartNfaWithStates_0(2, 30, 35);
            else if ((active1 & 0x200000000L) != 0L) {
                jjmatchedKind = 97;
                jjmatchedPos = 2;
            }
            return jjMoveStringLiteralDfa3_0(active0, 0x62000000000000L, active1, 0x2000000000000000L, active2, 0L);
        case 115:
            return jjMoveStringLiteralDfa3_0(active0, 0x800808400L, active1, 0L, active2, 0L);
        case 116:
            if ((active0 & 0x1000000000L) != 0L) {
                jjmatchedKind = 36;
                jjmatchedPos = 2;
            } else if ((active1 & 0x80000L) != 0L) {
                jjmatchedKind = 83;
                jjmatchedPos = 2;
            } else if ((active1 & 0x200000L) != 0L) {
                jjmatchedKind = 85;
                jjmatchedPos = 2;
            }
            return jjMoveStringLiteralDfa3_0(active0, 0x40a082014000L, active1, 0x50000000L, active2, 0L);
        case 117:
            return jjMoveStringLiteralDfa3_0(active0, 0x80000001400000L, active1, 0L, active2, 0L);
        case 119:
            if ((active0 & 0x10000000000L) != 0L)
                return jjStartNfaWithStates_0(2, 40, 35);
            break;
        case 121:
            if ((active0 & 0x100000000000000L) != 0L)
                return jjStartNfaWithStates_0(2, 56, 35);
            break;
        default:
            break;
    }
    return jjStartNfa_0(1, active0, active1, active2);
}