private final int jjMoveStringLiteralDfa1_0(long active0, long active1, long active2) {
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(0, active0, active1, active2);
        return 1;
    }
    switch(curChar) {
        case 38:
            if ((active1 & 0x400000000L) != 0L)
                return jjStopAtPos(1, 98);
            break;
        case 43:
            if ((active1 & 0x1000000000L) != 0L)
                return jjStopAtPos(1, 100);
            break;
        case 45:
            if ((active1 & 0x2000000000L) != 0L)
                return jjStopAtPos(1, 101);
            break;
        case 60:
            if ((active1 & 0x1000000000000L) != 0L) {
                jjmatchedKind = 112;
                jjmatchedPos = 1;
            }
            return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0L, active2, 0x1L);
        case 61:
            if ((active1 & 0x4000000L) != 0L)
                return jjStopAtPos(1, 90);
            else if ((active1 & 0x8000000L) != 0L)
                return jjStopAtPos(1, 91);
            else if ((active1 & 0x20000000L) != 0L)
                return jjStopAtPos(1, 93);
            else if ((active1 & 0x80000000L) != 0L)
                return jjStopAtPos(1, 95);
            else if ((active1 & 0x40000000000000L) != 0L)
                return jjStopAtPos(1, 118);
            else if ((active1 & 0x80000000000000L) != 0L)
                return jjStopAtPos(1, 119);
            else if ((active1 & 0x100000000000000L) != 0L)
                return jjStopAtPos(1, 120);
            else if ((active1 & 0x200000000000000L) != 0L)
                return jjStopAtPos(1, 121);
            else if ((active1 & 0x400000000000000L) != 0L)
                return jjStopAtPos(1, 122);
            else if ((active1 & 0x1000000000000000L) != 0L)
                return jjStopAtPos(1, 124);
            else if ((active1 & 0x4000000000000000L) != 0L)
                return jjStopAtPos(1, 126);
            else if ((active1 & 0x8000000000000000L) != 0L)
                return jjStopAtPos(1, 127);
            break;
        case 62:
            if ((active1 & 0x4000000000000L) != 0L) {
                jjmatchedKind = 114;
                jjmatchedPos = 1;
            }
            return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x10000000000000L, active2, 0x14L);
        case 97:
            return jjMoveStringLiteralDfa2_0(active0, 0x48004018000L, active1, 0x800000800000000L, active2, 0L);
        case 98:
            return jjMoveStringLiteralDfa2_0(active0, 0x400L, active1, 0x280000000000L, active2, 0L);
        case 101:
            return jjMoveStringLiteralDfa2_0(active0, 0x410000100000L, active1, 0L, active2, 0L);
        case 102:
            if ((active0 & 0x100000000L) != 0L)
                return jjStartNfaWithStates_0(1, 32, 35);
            break;
        case 103:
            return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x40080000L, active2, 0L);
        case 104:
            return jjMoveStringLiteralDfa2_0(active0, 0x860800000020000L, active1, 0L, active2, 0L);
        case 105:
            return jjMoveStringLiteralDfa2_0(active0, 0x18000000L, active1, 0L, active2, 0L);
        case 108:
            return jjMoveStringLiteralDfa2_0(active0, 0x20802000L, active1, 0x2000010200000L, active2, 0x2L);
        case 109:
            return jjMoveStringLiteralDfa2_0(active0, 0x600000000L, active1, 0L, active2, 0L);
        case 110:
            return jjMoveStringLiteralDfa2_0(active0, 0x3801000000L, active1, 0L, active2, 0L);
        case 111:
            if ((active0 & 0x200000L) != 0L) {
                jjmatchedKind = 21;
                jjmatchedPos = 1;
            }
            return jjMoveStringLiteralDfa2_0(active0, 0x6000040c04c0800L, active1, 0x2000000200000000L, active2, 0L);
        case 114:
            return jjMoveStringLiteralDfa2_0(active0, 0x190180000001000L, active1, 0x28000000000000L, active2, 0x28L);
        case 116:
            return jjMoveStringLiteralDfa2_0(active0, 0x3000000000000L, active1, 0L, active2, 0L);
        case 117:
            return jjMoveStringLiteralDfa2_0(active0, 0x220000000000L, active1, 0L, active2, 0L);
        case 119:
            return jjMoveStringLiteralDfa2_0(active0, 0x4000000000000L, active1, 0L, active2, 0L);
        case 120:
            return jjMoveStringLiteralDfa2_0(active0, 0x2000000L, active1, 0L, active2, 0L);
        case 121:
            return jjMoveStringLiteralDfa2_0(active0, 0x8000000004000L, active1, 0L, active2, 0L);
        case 124:
            if ((active1 & 0x100000000L) != 0L)
                return jjStopAtPos(1, 96);
            break;
        default:
            break;
    }
    return jjStartNfa_0(0, active0, active1, active2);
}