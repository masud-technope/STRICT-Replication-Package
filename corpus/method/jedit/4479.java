public static IndentRule indentCloseBracket(char bracket) throws PatternSyntaxException {
    return new CloseBracketIndentRule(bracket, true);
}