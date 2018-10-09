public static IndentRule unindentThisLine(String regexp) throws PatternSyntaxException {
    return new RegexpIndentRule(regexp, null, new IndentAction.Increase(), new IndentAction.Decrease(), false);
}