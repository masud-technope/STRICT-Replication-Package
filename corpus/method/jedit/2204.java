private final int jjMoveStringLiteralDfa26_0(long old2, long active2) {
    if (((active2 &= old2)) == 0L)
        return jjStartNfa_0(24, 0L, 0L, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(25, 0L, 0L, active2);
        return 26;
    }
    switch(curChar) {
        case 103:
            return jjMoveStringLiteralDfa27_0(active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(25, 0L, 0L, active2);
}