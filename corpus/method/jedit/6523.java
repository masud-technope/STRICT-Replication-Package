//{{{ getStandardRuleSet() method
/**
	 * Returns a parser rule set that highlights everything with the
	 * specified token type.
	 * @param id The token type
	 */
public static ParserRuleSet getStandardRuleSet(byte id) {
    return standard[id];
}