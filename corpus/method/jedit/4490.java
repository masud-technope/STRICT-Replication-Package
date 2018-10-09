public void handleToken(Segment seg, byte id, int offset, int length, TokenMarker.LineContext context) {
    // string.
    if (length <= 0) {
        return;
    }
    switch(id) {
        case Token.COMMENT1:
        case Token.COMMENT2:
        case Token.COMMENT3:
        case Token.COMMENT4:
            // Replace any comments to a white space
            // so that they are simply ignored.
            result.append(' ');
            break;
        case Token.LITERAL1:
        case Token.LITERAL2:
        case Token.LITERAL3:
        case Token.LITERAL4:
            // Replace any literals to a '0' which means
            // a simple integer literal in most programming
            // languages.
            result.append('0');
            break;
        default:
            result.append(seg.array, seg.offset + offset, length);
            break;
    }
}