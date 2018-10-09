public synchronized List<IndentRule> getIndentRules() {
    if (indentRules == null) {
        initIndentRules();
    }
    return indentRules;
}