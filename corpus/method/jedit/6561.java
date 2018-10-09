//{{{ setInRule() method
/**
		 * Sets the current rule being processed and adjusts the
		 * escape rule for the context based on the rule.
		 */
public void setInRule(ParserRule rule) {
    inRule = rule;
    if (rule != null && rule.escapeRule != null)
        escapeRule = rule.escapeRule;
    else if (rules != null && rules.getModeName() != null)
        escapeRule = rules.getEscapeRule();
    else if (parent != null)
        escapeRule = parent.escapeRule;
    else
        escapeRule = null;
//}}}
}