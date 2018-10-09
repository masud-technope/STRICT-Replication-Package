private final int jjMoveStringLiteralDfa21_0(long old1, long active1, long old2, long active2) {
    if (((active1 &= old1) | (active2 &= old2)) == 0L)
        return jjStartNfa_0(19, 0L, old1, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(20, 0L, 0L, active2);
        return 21;
    }
    switch(curChar) {
        case 95:
            return jjMoveStringLiteralDfa22_0(active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(20, 0L, 0L, active2);
}