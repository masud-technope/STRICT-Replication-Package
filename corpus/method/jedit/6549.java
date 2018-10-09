//{{{ LineContext constructor
public  LineContext(ParserRuleSet rs, LineContext lc) {
    rules = rs;
    parent = (lc == null ? null : (LineContext) lc.clone());
    /*
			 * SPANs with no delegate need to propagate the
			 * escape rule to the child context, so this is
			 * needed.
			 */
    if (rs.getModeName() != null)
        escapeRule = rules.getEscapeRule();
    else
        escapeRule = lc.escapeRule;
//}}}
}