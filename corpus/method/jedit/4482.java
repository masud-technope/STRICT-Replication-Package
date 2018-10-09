public static IndentRule indentOpenBracket(char bracket) throws PatternSyntaxException {
    return new OpenBracketIndentRule(bracket, true);
}