//}}}
//}}}
//{{{ Protected members
@Override
protected TokenMarker.LineContext markTokens(Segment seg, TokenMarker.LineContext prevContext, TokenHandler _tokenHandler) {
    TokenMarker.LineContext context;
    if (longBufferMode && longLineLimit != 0 && longLineLimit < seg.length()) {
        context = textTokenMarker.markTokens(prevContext, _tokenHandler, seg);
    } else {
        context = tokenMarker.markTokens(prevContext, _tokenHandler, seg);
    }
    return context;
}