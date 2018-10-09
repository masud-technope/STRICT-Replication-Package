public static IndentRule unalignedCloseBracket(char bracket) throws PatternSyntaxException {
    return new CloseBracketIndentRule(bracket, false);
}