//}}}
//{{{ isElectricKey() methods
/**
	 * Should inserting this character trigger a re-indent of
	 * the current line?
	 * @param ch a character
	 * @param line the line
	 * @return true if is electric key
	 * @since jEdit 4.3pre9
	 */
public boolean isElectricKey(char ch, int line) {
    TokenMarker.LineContext ctx = getLineContext(line);
    Mode mode = ModeProvider.instance.getMode(ctx.rules.getModeName());
    // mode can be null, though that's probably an error "further up":
    if (mode == null)
        return false;
    return mode.isElectricKey(ch);
}