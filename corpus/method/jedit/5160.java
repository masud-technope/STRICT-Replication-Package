private IndentRule createRegexpIndentRule(String prop) {
    String value = (String) getProperty(prop);
    try {
        if (value != null) {
            Method m = IndentRuleFactory.class.getMethod(prop, String.class);
            return (IndentRule) m.invoke(null, value);
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "Bad indent rule " + prop + '=' + value + ':');
        Log.log(Log.ERROR, this, e);
    }
    return null;
}