//}}}
//{{{ startElement() method
public void startElement(String uri, String localName, String qName, Attributes attrs) {
    TagDecl tag = pushElement(qName, attrs);
    if (qName.equals("WHITESPACE")) {
        Log.log(Log.WARNING, this, modeName + ": WHITESPACE rule " + "no longer needed");
    } else if (qName.equals("KEYWORDS")) {
        keywords = new KeywordMap(rules.getIgnoreCase());
    } else if (qName.equals("RULES")) {
        if (tag.lastSetName == null)
            tag.lastSetName = "MAIN";
        rules = marker.getRuleSet(tag.lastSetName);
        if (rules == null) {
            rules = new ParserRuleSet(modeName, tag.lastSetName);
            marker.addRuleSet(rules);
        }
        rules.setIgnoreCase(tag.lastIgnoreCase);
        rules.setHighlightDigits(tag.lastHighlightDigits);
        if (tag.lastDigitRE != null) {
            try {
                rules.setDigitRegexp(Pattern.compile(tag.lastDigitRE, tag.lastIgnoreCase ? Pattern.CASE_INSENSITIVE : 0));
            } catch (PatternSyntaxException e) {
                error("regexp", e);
            }
        }
        if (tag.lastEscape != null)
            rules.setEscapeRule(ParserRule.createEscapeRule(tag.lastEscape));
        rules.setDefault(tag.lastDefaultID);
        rules.setNoWordSep(tag.lastNoWordSep);
    }
}