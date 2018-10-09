public static IndentRule unindentNextLines(String regexp) throws PatternSyntaxException {
    return new RegexpIndentRule(regexp, null, new IndentAction.Decrease(), null, false);
}