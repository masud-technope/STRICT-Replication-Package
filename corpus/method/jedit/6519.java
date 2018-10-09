//}}}
//{{{ resolveImports() method
/**
	 * Resolves all rulesets added with {@link #addRuleSet(ParserRuleSet)}.
	 * @since jEdit 4.2pre3
	 */
public void resolveImports() {
    for (ParserRuleSet ruleset : imports) {
        if (!ruleset.imports.isEmpty()) {
            //prevent infinite recursion
            ruleset.imports.remove(this);
            ruleset.resolveImports();
        }
        for (List<ParserRule> rules : ruleset.ruleMap.values()) {
            for (ParserRule rule : rules) {
                addRule(rule);
            }
        }
        if (ruleset.keywords != null) {
            if (keywords == null)
                keywords = new KeywordMap(ignoreCase);
            keywords.add(ruleset.keywords);
        }
    }
    imports.clear();
}