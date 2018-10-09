//}}}
//{{{ createToken() method
protected Token createToken(byte id, int offset, int length, TokenMarker.LineContext context) {
    return new Token(id, offset, length, getParserRuleSet(context));
}