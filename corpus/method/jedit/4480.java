public static IndentRule unalignedOpenBracket(char bracket) throws PatternSyntaxException {
    return new OpenBracketIndentRule(bracket, false);
}