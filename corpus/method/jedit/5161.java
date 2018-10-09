private void createBracketIndentRules(String prop, Collection<IndentRule> rules) {
    String value = (String) getProperty(prop + 's');
    try {
        if (value != null) {
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                Method m = IndentRuleFactory.class.getMethod(prop, char.class);
                rules.add((IndentRule) m.invoke(null, ch));
            }
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "Bad indent rule " + prop + '=' + value + ':');
        Log.log(Log.ERROR, this, e);
    }
}