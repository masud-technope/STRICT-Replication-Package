/**
	 * @param collapse If true, then if the next indent rule is
	 * an opening bracket, this rule will not increase indent.
	 */
public  RegexpIndentRule(String regexp, IndentAction prevPrev, IndentAction prev, IndentAction thisLine, boolean collapse) throws PatternSyntaxException {
    prevPrevAction = prevPrev;
    prevAction = prev;
    thisAction = thisLine;
    this.regexp = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
    this.collapse = collapse;
}