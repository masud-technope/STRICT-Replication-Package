private void initIndentRules() {
    List<IndentRule> rules = new LinkedList<IndentRule>();
    String[] regexpProps = { "indentNextLine", "indentNextLines" };
    for (int i = 0; i < regexpProps.length; i++) {
        IndentRule rule = createRegexpIndentRule(regexpProps[i]);
        if (rule != null)
            rules.add(rule);
    }
    String[] bracketProps = { "indentOpenBracket", "indentCloseBracket", "unalignedOpenBracket", "unalignedCloseBracket" };
    for (String bracketProp : bracketProps) createBracketIndentRules(bracketProp, rules);
    String[] finalProps = { "unindentThisLine", "unindentNextLines" };
    for (int i = 0; i < finalProps.length; i++) {
        IndentRule rule = createRegexpIndentRule(finalProps[i]);
        if (rule != null)
            rules.add(rule);
    }
    if (getBooleanProperty("deepIndent")) {
        String unalignedOpenBrackets = (String) getProperty("unalignedOpenBrackets");
        if (unalignedOpenBrackets != null) {
            for (int i = 0; i < unalignedOpenBrackets.length(); i++) {
                char openChar = unalignedOpenBrackets.charAt(i);
                char closeChar = TextUtilities.getComplementaryBracket(openChar, null);
                if (closeChar != '\0')
                    rules.add(new DeepIndentRule(openChar, closeChar));
            }
        }
    }
    if (!getIgnoreWhitespace())
        rules.add(new WhitespaceRule());
    indentRules = Collections.unmodifiableList(rules);
}