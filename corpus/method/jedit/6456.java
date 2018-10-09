//}}}
//{{{ addToken() method
protected void addToken(Token token, TokenMarker.LineContext context) {
    if (firstToken == null) {
        firstToken = lastToken = token;
    } else {
        lastToken.next = token;
        lastToken = lastToken.next;
    }
}