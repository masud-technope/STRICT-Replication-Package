public static IndentRule indentNextLine(String regexp) throws PatternSyntaxException {
    return new RegexpIndentRule(regexp, new IndentAction.Decrease(), new IndentAction.Increase(), null, true);
}