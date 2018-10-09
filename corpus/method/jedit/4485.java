public static IndentRule indentNextLines(String regexp) throws PatternSyntaxException {
    return new RegexpIndentRule(regexp, null, new IndentAction.Increase(), null, false);
}