private  ParserRule(char[] hashChars, int action, int startPosMatch, char[] start, Pattern startRegexp, int endPosMatch, char[] end, Pattern endRegexp, ParserRuleSet delegate, byte token, byte matchType, String escape) {
    this.action = action;
    this.upHashChar = null;
    Set<Character> hashCharsSet = new HashSet<Character>();
    for (char c : hashChars) {
        hashCharsSet.add(Character.toUpperCase(c));
    }
    this.upHashChars = new char[hashCharsSet.size()];
    int i = 0;
    for (Character c : hashCharsSet) {
        this.upHashChars[i++] = c;
    }
    Arrays.sort(this.upHashChars);
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