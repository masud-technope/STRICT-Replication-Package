public final Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
        if (t.next != null)
            t = t.next;
        else
            t = t.next = token_source.getNextToken();
    }
    return t;
}