public void handleToken(Segment seg, byte id, int offset, int length, TokenMarker.LineContext context) {
    // Accepts all others.
    if (!Token.isCommentOrLiteral(id)) {
        scan(seg, offset, length);
    }
    scannedIndex += length;
}