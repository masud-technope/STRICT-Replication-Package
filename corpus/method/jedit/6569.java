//}}}
//{{{ getRuleSets() method
/**
	 * @since jEdit 4.2pre3
	 */
public ParserRuleSet[] getRuleSets() {
    return ruleSets.values().toArray(new ParserRuleSet[ruleSets.size()]);
}