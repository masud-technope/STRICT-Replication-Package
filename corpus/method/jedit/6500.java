//{{{ Private members
private  ParserRule(int action, String hashChar, int startPosMatch, char[] start, Pattern startRegexp, int endPosMatch, char[] end, Pattern endRegexp, ParserRuleSet delegate, byte token, byte matchType, String escape) {
    this.action = action;
    this.upHashChar = null == hashChar ? null : hashChar.toUpperCase().toCharArray();
    this.upHashChars = null;
    this.startPosMatch = startPosMatch;
    this.start = start;
    this.startRegexp = startRegexp;
    this.endPosMatch = endPosMatch;
    this.end = end;
    this.endRegexp = endRegexp;
    this.delegate = delegate;
    this.token = token;
    this.matchType = matchType;
    this.escapeRule = (escape != null && escape.length() > 0) ? createEscapeRule(escape) : null;
    if (this.delegate == null) {
        if ((action & MAJOR_ACTIONS) != SEQ) {
            this.delegate = ParserRuleSet.getStandardRuleSet(token);
        }
    }
}