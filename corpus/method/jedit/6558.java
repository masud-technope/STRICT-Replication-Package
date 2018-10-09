//}}}
//{{{ handleTokenWithSpaces() method
private void handleTokenWithSpaces(TokenHandler tokenHandler, byte tokenType, int start, int len, LineContext context) {
    int last = start;
    int end = start + len;
    for (int i = start; i < end; i++) {
        if (Character.isWhitespace(line.array[i + line.offset])) {
            if (last != i) {
                tokenHandler.handleToken(line, tokenType, last, i - last, context);
            }
            tokenHandler.handleToken(line, tokenType, i, 1, context);
            last = i + 1;
        }
    }
    if (last != end) {
        tokenHandler.handleToken(line, tokenType, last, end - last, context);
    }
}