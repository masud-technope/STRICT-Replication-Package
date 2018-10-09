private final int jjMoveStringLiteralDfa25_0(long old2, long active2) {
    if (((active2 &= old2)) == 0L)
        return jjStartNfa_0(23, 0L, 0L, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(24, 0L, 0L, active2);
        return 25;
    }
    switch(curChar) {
        case 105:
            return jjMoveStringLiteralDfa26_0(active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(24, 0L, 0L, active2);
}