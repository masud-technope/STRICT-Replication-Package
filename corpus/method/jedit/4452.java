 Parens(JEditBuffer b, int line, int pos) {
    this.searchPos = pos;
    this.open = new Stack<Integer>();
    this.close = new Stack<Integer>();
    b.markTokens(line, this);
    openOffset = (open.isEmpty()) ? -1 : open.pop();
    closeOffset = (close.isEmpty()) ? -1 : close.pop();
}