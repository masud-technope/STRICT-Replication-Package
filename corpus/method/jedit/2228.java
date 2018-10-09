private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1, long active2) {
    switch(pos) {
        case 0:
            if ((active1 & 0x200020000000000L) != 0L)
                return 56;
            if ((active0 & 0x3eL) != 0L)
                return 0;
            if ((active1 & 0x10000L) != 0L)
                return 11;
            if ((active0 & 0xffffffffffffc00L) != 0L) {
                jjmatchedKind = 69;
                return 35;
            }
            return -1;
        case 1:
            if ((active0 & 0x100600000L) != 0L)
                return 35;
            if ((active0 & 0xffffffeff9ffc00L) != 0L) {
                if (jjmatchedPos != 1) {
                    jjmatchedKind = 69;
                    jjmatchedPos = 1;
                }
                return 35;
            }
            return -1;
        case 2:
            if ((active0 & 0xefffecebfdffc00L) != 0L) {
                if (jjmatchedPos != 2) {
                    jjmatchedKind = 69;
                    jjmatchedPos = 2;
                }
                return 35;
            }
            if ((active0 & 0x100013040000000L) != 0L)
                return 35;
            return -1;
        case 3:
            if ((active0 & 0xc7ffcae3e5d3c00L) != 0L) {
                if (jjmatchedPos != 3) {
                    jjmatchedKind = 69;
                    jjmatchedPos = 3;
                }
                return 35;
            }
            if ((active0 & 0x28002408182c000L) != 0L)
                return 35;
            return -1;
        case 4:
            if ((active0 & 0x86080003c053000L) != 0L)
                return 35;
            if ((active0 & 0x41f7cae02580c00L) != 0L) {
                if (jjmatchedPos != 4) {
                    jjmatchedKind = 69;
                    jjmatchedPos = 4;
                }
                return 35;
            }
            return -1;
        case 5:
            if ((active0 & 0x41a1c2a12180c00L) != 0L) {
                jjmatchedKind = 69;
                jjmatchedPos = 5;
                return 35;
            }
            if ((active0 & 0x45608400400000L) != 0L)
                return 35;
            return -1;
        case 6:
            if ((active0 & 0x41a102a00080400L) != 0L) {
                jjmatchedKind = 69;
                jjmatchedPos = 6;
                return 35;
            }
            if ((active0 & 0xc0012100800L) != 0L)
                return 35;
            return -1;
        case 7:
            if ((active0 & 0x402000000080400L) != 0L)
                return 35;
            if ((active0 & 0x18102a00000000L) != 0L) {
                jjmatchedKind = 69;
                jjmatchedPos = 7;
                return 35;
            }
            return -1;
        case 8:
            if ((active0 & 0x8000a00000000L) != 0L) {
                jjmatchedKind = 69;
                jjmatchedPos = 8;
                return 35;
            }
            if ((active0 & 0x10102000000000L) != 0L)
                return 35;
            return -1;
        case 9:
            if ((active0 & 0x8000000000000L) != 0L) {
                jjmatchedKind = 69;
                jjmatchedPos = 9;
                return 35;
            }
            if ((active0 & 0xa00000000L) != 0L)
                return 35;
            return -1;
        case 10:
            if ((active0 & 0x8000000000000L) != 0L) {
                if (jjmatchedPos != 10) {
                    jjmatchedKind = 69;
                    jjmatchedPos = 10;
                }
                return 35;
            }
            return -1;
        case 11:
            if ((active0 & 0x8000000000000L) != 0L)
                return 35;
            return -1;
        default:
            return -1;
    }
}