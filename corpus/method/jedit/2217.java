protected Token jjFillToken() {
    Token t = Token.newToken(jjmatchedKind);
    t.kind = jjmatchedKind;
    String im = jjstrLiteralImages[jjmatchedKind];
    t.image = (im == null) ? input_stream.GetImage() : im;
    t.beginLine = input_stream.getBeginLine();
    t.beginColumn = input_stream.getBeginColumn();
    t.endLine = input_stream.getEndLine();
    t.endColumn = input_stream.getEndColumn();
    return t;
}