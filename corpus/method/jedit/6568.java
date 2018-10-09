//{{{ addRuleSet() method
public void addRuleSet(ParserRuleSet rules) {
    ruleSets.put(rules.getSetName(), rules);
    if ("MAIN".equals(rules.getSetName()))
        mainRuleSet = rules;
}