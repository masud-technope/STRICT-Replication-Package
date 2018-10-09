private final int jjMoveNfa_0(int startState, int curPos) {
    int[] nextStates;
    int startsAt = 0;
    jjnewStateCnt = 74;
    int i = 1;
    jjstateSet[0] = startState;
    int j, kind = 0x7fffffff;
    for (; ; ) {
        if (++jjround == 0x7fffffff)
            ReInitRounds();
        if (curChar < 64) {
            long l = 1L << curChar;
            MatchLoop: do {
                switch(jjstateSet[--i]) {
                    case 6:
                        if ((0x1ffffffffL & l) != 0L) {
                            if (kind > 6)
                                kind = 6;
                            jjCheckNAdd(0);
                        } else if ((0x3ff000000000000L & l) != 0L)
                            jjCheckNAddStates(0, 6);
                        else if (curChar == 47)
                            jjAddStates(7, 9);
                        else if (curChar == 36) {
                            if (kind > 69)
                                kind = 69;
                            jjCheckNAdd(35);
                        } else if (curChar == 34)
                            jjCheckNAddStates(10, 12);
                        else if (curChar == 39)
                            jjAddStates(13, 14);
                        else if (curChar == 46)
                            jjCheckNAdd(11);
                        else if (curChar == 35)
                            jjstateSet[jjnewStateCnt++] = 1;
                        if ((0x3fe000000000000L & l) != 0L) {
                            if (kind > 60)
                                kind = 60;
                            jjCheckNAddTwoStates(8, 9);
                        } else if (curChar == 48) {
                            if (kind > 60)
                                kind = 60;
                            jjCheckNAddStates(15, 17);
                        }
                        break;
                    case 56:
                        if (curChar == 42)
                            jjstateSet[jjnewStateCnt++] = 67;
                        else if (curChar == 47) {
                            if (kind > 7)
                                kind = 7;
                            jjCheckNAddStates(18, 20);
                        }
                        if (curChar == 42)
                            jjCheckNAdd(62);
                        break;
                    case 0:
                        if ((0x1ffffffffL & l) == 0L)
                            break;
                        if (kind > 6)
                            kind = 6;
                        jjCheckNAdd(0);
                        break;
                    case 1:
                        if (curChar == 33)
                            jjCheckNAddStates(21, 23);
                        break;
                    case 2:
                        if ((0xffffffffffffdbffL & l) != 0L)
                            jjCheckNAddStates(21, 23);
                        break;
                    case 3:
                        if ((0x2400L & l) != 0L && kind > 8)
                            kind = 8;
                        break;
                    case 4:
                        if (curChar == 10 && kind > 8)
                            kind = 8;
                        break;
                    case 5:
                        if (curChar == 13)
                            jjstateSet[jjnewStateCnt++] = 4;
                        break;
                    case 7:
                        if ((0x3fe000000000000L & l) == 0L)
                            break;
                        if (kind > 60)
                            kind = 60;
                        jjCheckNAddTwoStates(8, 9);
                        break;
                    case 8:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 60)
                            kind = 60;
                        jjCheckNAddTwoStates(8, 9);
                        break;
                    case 10:
                        if (curChar == 46)
                            jjCheckNAdd(11);
                        break;
                    case 11:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 64)
                            kind = 64;
                        jjCheckNAddStates(24, 26);
                        break;
                    case 13:
                        if ((0x280000000000L & l) != 0L)
                            jjCheckNAdd(14);
                        break;
                    case 14:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 64)
                            kind = 64;
                        jjCheckNAddTwoStates(14, 15);
                        break;
                    case 16:
                        if (curChar == 39)
                            jjAddStates(13, 14);
                        break;
                    case 17:
                        if ((0xffffff7fffffdbffL & l) != 0L)
                            jjCheckNAdd(18);
                        break;
                    case 18:
                        if (curChar == 39 && kind > 66)
                            kind = 66;
                        break;
                    case 20:
                        if ((0x8400000000L & l) != 0L)
                            jjCheckNAdd(18);
                        break;
                    case 21:
                        if ((0xff000000000000L & l) != 0L)
                            jjCheckNAddTwoStates(22, 18);
                        break;
                    case 22:
                        if ((0xff000000000000L & l) != 0L)
                            jjCheckNAdd(18);
                        break;
                    case 23:
                        if ((0xf000000000000L & l) != 0L)
                            jjstateSet[jjnewStateCnt++] = 24;
                        break;
                    case 24:
                        if ((0xff000000000000L & l) != 0L)
                            jjCheckNAdd(22);
                        break;
                    case 25:
                        if (curChar == 34)
                            jjCheckNAddStates(10, 12);
                        break;
                    case 26:
                        if ((0xfffffffbffffdbffL & l) != 0L)
                            jjCheckNAddStates(10, 12);
                        break;
                    case 28:
                        if ((0x8400000000L & l) != 0L)
                            jjCheckNAddStates(10, 12);
                        break;
                    case 29:
                        if (curChar == 34 && kind > 67)
                            kind = 67;
                        break;
                    case 30:
                        if ((0xff000000000000L & l) != 0L)
                            jjCheckNAddStates(27, 30);
                        break;
                    case 31:
                        if ((0xff000000000000L & l) != 0L)
                            jjCheckNAddStates(10, 12);
                        break;
                    case 32:
                        if ((0xf000000000000L & l) != 0L)
                            jjstateSet[jjnewStateCnt++] = 33;
                        break;
                    case 33:
                        if ((0xff000000000000L & l) != 0L)
                            jjCheckNAdd(31);
                        break;
                    case 34:
                        if (curChar != 36)
                            break;
                        if (kind > 69)
                            kind = 69;
                        jjCheckNAdd(35);
                        break;
                    case 35:
                        if ((0x3ff001000000000L & l) == 0L)
                            break;
                        if (kind > 69)
                            kind = 69;
                        jjCheckNAdd(35);
                        break;
                    case 36:
                        if ((0x3ff000000000000L & l) != 0L)
                            jjCheckNAddStates(0, 6);
                        break;
                    case 37:
                        if ((0x3ff000000000000L & l) != 0L)
                            jjCheckNAddTwoStates(37, 38);
                        break;
                    case 38:
                        if (curChar != 46)
                            break;
                        if (kind > 64)
                            kind = 64;
                        jjCheckNAddStates(31, 33);
                        break;
                    case 39:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 64)
                            kind = 64;
                        jjCheckNAddStates(31, 33);
                        break;
                    case 41:
                        if ((0x280000000000L & l) != 0L)
                            jjCheckNAdd(42);
                        break;
                    case 42:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 64)
                            kind = 64;
                        jjCheckNAddTwoStates(42, 15);
                        break;
                    case 43:
                        if ((0x3ff000000000000L & l) != 0L)
                            jjCheckNAddTwoStates(43, 44);
                        break;
                    case 45:
                        if ((0x280000000000L & l) != 0L)
                            jjCheckNAdd(46);
                        break;
                    case 46:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 64)
                            kind = 64;
                        jjCheckNAddTwoStates(46, 15);
                        break;
                    case 47:
                        if ((0x3ff000000000000L & l) != 0L)
                            jjCheckNAddStates(34, 36);
                        break;
                    case 49:
                        if ((0x280000000000L & l) != 0L)
                            jjCheckNAdd(50);
                        break;
                    case 50:
                        if ((0x3ff000000000000L & l) != 0L)
                            jjCheckNAddTwoStates(50, 15);
                        break;
                    case 51:
                        if (curChar != 48)
                            break;
                        if (kind > 60)
                            kind = 60;
                        jjCheckNAddStates(15, 17);
                        break;
                    case 53:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 60)
                            kind = 60;
                        jjCheckNAddTwoStates(53, 9);
                        break;
                    case 54:
                        if ((0xff000000000000L & l) == 0L)
                            break;
                        if (kind > 60)
                            kind = 60;
                        jjCheckNAddTwoStates(54, 9);
                        break;
                    case 55:
                        if (curChar == 47)
                            jjAddStates(7, 9);
                        break;
                    case 57:
                        if ((0xffffffffffffdbffL & l) == 0L)
                            break;
                        if (kind > 7)
                            kind = 7;
                        jjCheckNAddStates(18, 20);
                        break;
                    case 58:
                        if ((0x2400L & l) != 0L && kind > 7)
                            kind = 7;
                        break;
                    case 59:
                        if (curChar == 10 && kind > 7)
                            kind = 7;
                        break;
                    case 60:
                        if (curChar == 13)
                            jjstateSet[jjnewStateCnt++] = 59;
                        break;
                    case 61:
                        if (curChar == 42)
                            jjCheckNAdd(62);
                        break;
                    case 62:
                        if ((0xfffffbffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(62, 63);
                        break;
                    case 63:
                        if (curChar == 42)
                            jjCheckNAddStates(37, 39);
                        break;
                    case 64:
                        if ((0xffff7bffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(65, 63);
                        break;
                    case 65:
                        if ((0xfffffbffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(65, 63);
                        break;
                    case 66:
                        if (curChar == 47 && kind > 9)
                            kind = 9;
                        break;
                    case 67:
                        if (curChar == 42)
                            jjCheckNAddTwoStates(68, 69);
                        break;
                    case 68:
                        if ((0xfffffbffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(68, 69);
                        break;
                    case 69:
                        if (curChar == 42)
                            jjCheckNAddStates(40, 42);
                        break;
                    case 70:
                        if ((0xffff7bffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(71, 69);
                        break;
                    case 71:
                        if ((0xfffffbffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(71, 69);
                        break;
                    case 72:
                        if (curChar == 47 && kind > 68)
                            kind = 68;
                        break;
                    case 73:
                        if (curChar == 42)
                            jjstateSet[jjnewStateCnt++] = 67;
                        break;
                    default:
                        break;
                }
            } while (i != startsAt);
        } else if (curChar < 128) {
            long l = 1L << (curChar & 077);
            MatchLoop: do {
                switch(jjstateSet[--i]) {
                    case 6:
                    case 35:
                        if ((0x7fffffe87fffffeL & l) == 0L)
                            break;
                        if (kind > 69)
                            kind = 69;
                        jjCheckNAdd(35);
                        break;
                    case 2:
                        jjAddStates(21, 23);
                        break;
                    case 9:
                        if ((0x100000001000L & l) != 0L && kind > 60)
                            kind = 60;
                        break;
                    case 12:
                        if ((0x2000000020L & l) != 0L)
                            jjAddStates(43, 44);
                        break;
                    case 15:
                        if ((0x5000000050L & l) != 0L && kind > 64)
                            kind = 64;
                        break;
                    case 17:
                        if ((0xffffffffefffffffL & l) != 0L)
                            jjCheckNAdd(18);
                        break;
                    case 19:
                        if (curChar == 92)
                            jjAddStates(45, 47);
                        break;
                    case 20:
                        if ((0x14404410000000L & l) != 0L)
                            jjCheckNAdd(18);
                        break;
                    case 26:
                        if ((0xffffffffefffffffL & l) != 0L)
                            jjCheckNAddStates(10, 12);
                        break;
                    case 27:
                        if (curChar == 92)
                            jjAddStates(48, 50);
                        break;
                    case 28:
                        if ((0x14404410000000L & l) != 0L)
                            jjCheckNAddStates(10, 12);
                        break;
                    case 40:
                        if ((0x2000000020L & l) != 0L)
                            jjAddStates(51, 52);
                        break;
                    case 44:
                        if ((0x2000000020L & l) != 0L)
                            jjAddStates(53, 54);
                        break;
                    case 48:
                        if ((0x2000000020L & l) != 0L)
                            jjAddStates(55, 56);
                        break;
                    case 52:
                        if ((0x100000001000000L & l) != 0L)
                            jjCheckNAdd(53);
                        break;
                    case 53:
                        if ((0x7e0000007eL & l) == 0L)
                            break;
                        if (kind > 60)
                            kind = 60;
                        jjCheckNAddTwoStates(53, 9);
                        break;
                    case 57:
                        if (kind > 7)
                            kind = 7;
                        jjAddStates(18, 20);
                        break;
                    case 62:
                        jjCheckNAddTwoStates(62, 63);
                        break;
                    case 64:
                    case 65:
                        jjCheckNAddTwoStates(65, 63);
                        break;
                    case 68:
                        jjCheckNAddTwoStates(68, 69);
                        break;
                    case 70:
                    case 71:
                        jjCheckNAddTwoStates(71, 69);
                        break;
                    default:
                        break;
                }
            } while (i != startsAt);
        } else {
            int hiByte = (int) (curChar >> 8);
            int i1 = hiByte >> 6;
            long l1 = 1L << (hiByte & 077);
            int i2 = (curChar & 0xff) >> 6;
            long l2 = 1L << (curChar & 077);
            MatchLoop: do {
                switch(jjstateSet[--i]) {
                    case 6:
                        if (jjCanMove_0(hiByte, i1, i2, l1, l2)) {
                            if (kind > 6)
                                kind = 6;
                            jjCheckNAdd(0);
                        }
                        if (jjCanMove_2(hiByte, i1, i2, l1, l2)) {
                            if (kind > 69)
                                kind = 69;
                            jjCheckNAdd(35);
                        }
                        break;
                    case 0:
                        if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                            break;
                        if (kind > 6)
                            kind = 6;
                        jjCheckNAdd(0);
                        break;
                    case 2:
                        if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                            jjAddStates(21, 23);
                        break;
                    case 17:
                        if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                            jjstateSet[jjnewStateCnt++] = 18;
                        break;
                    case 26:
                        if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                            jjAddStates(10, 12);
                        break;
                    case 34:
                    case 35:
                        if (!jjCanMove_2(hiByte, i1, i2, l1, l2))
                            break;
                        if (kind > 69)
                            kind = 69;
                        jjCheckNAdd(35);
                        break;
                    case 57:
                        if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                            break;
                        if (kind > 7)
                            kind = 7;
                        jjAddStates(18, 20);
                        break;
                    case 62:
                        if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                            jjCheckNAddTwoStates(62, 63);
                        break;
                    case 64:
                    case 65:
                        if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                            jjCheckNAddTwoStates(65, 63);
                        break;
                    case 68:
                        if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                            jjCheckNAddTwoStates(68, 69);
                        break;
                    case 70:
                    case 71:
                        if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                            jjCheckNAddTwoStates(71, 69);
                        break;
                    default:
                        break;
                }
            } while (i != startsAt);
        }
        if (kind != 0x7fffffff) {
            jjmatchedKind = kind;
            jjmatchedPos = curPos;
            kind = 0x7fffffff;
        }
        ++curPos;
        if ((i = jjnewStateCnt) == (startsAt = 74 - (jjnewStateCnt = startsAt)))
            return curPos;
        try {
            curChar = input_stream.readChar();
        } catch (java.io.IOException e) {
            return curPos;
        }
    }
}