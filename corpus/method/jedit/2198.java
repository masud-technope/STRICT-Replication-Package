private final int jjMoveStringLiteralDfa22_0(long old2, long active2) {
    if (((active2 &= old2)) == 0L)
        return jjStartNfa_0(20, 0L, 0L, old2);
    try {
        curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
        jjStopStringLiteralDfa_0(21, 0L, 0L, active2);
        return 22;
    }
    switch(curChar) {
        case 97:
            return jjMoveStringLiteralDfa23_0(active2, 0x20L);
        default:
            break;
    }
    return jjStartNfa_0(21, 0L, 0L, active2);
}