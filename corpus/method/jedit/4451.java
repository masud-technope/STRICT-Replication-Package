public void handleToken(Segment seg, byte id, int offset, int length, TokenMarker.LineContext context) {
    if (length <= 0 || (searchPos != -1 && searchPos < offset)) {
        return;
    }
    if (searchPos != -1 && offset + length > searchPos) {
        length = searchPos - offset + 1;
    }
    if (!Token.isCommentOrLiteral(id)) {
        for (int i = offset; i < offset + length; i++) {
            if (seg.array[seg.offset + i] == openChar) {
                if (open.isEmpty() && !close.isEmpty())
                    close.pop();
                else
                    open.push(i);
            } else if (seg.array[seg.offset + i] == closeChar) {
                if (close.isEmpty() && !open.isEmpty())
                    open.pop();
                else
                    close.push(i);
            }
        }
    }
}