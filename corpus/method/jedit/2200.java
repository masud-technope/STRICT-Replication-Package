private final int jjMoveStringLiteralDfa27_0(long old2, long active2) {
    if (((active2 &= old2)) == 0L)
        return jjStartNfa_0(25, 0L, 0L, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(26, 0L, 0L, active2);
        return 27;
    }
    switch(curChar) {
        case 110:
            if ((active2 & 0x20L) != 0L)
                return jjStopAtPos(27, 133);
            break;
        default:
            break;
    }
    return jjStartNfa_0(26, 0L, 0L, active2);
}