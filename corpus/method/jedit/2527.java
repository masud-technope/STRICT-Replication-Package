//}}}
//{{{ markTokens() method
protected TokenMarker.LineContext markTokens(Segment seg, TokenMarker.LineContext prevContext, TokenHandler _tokenHandler) {
    TokenMarker.LineContext context = tokenMarker.markTokens(prevContext, _tokenHandler, seg);
    return context;
}