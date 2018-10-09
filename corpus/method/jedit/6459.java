//}}}
//{{{ setLineContext() method
/**
	 * The token handler can compare this object with the object
	 * previously given for this line to see if the token type at the end
	 * of the line has changed (meaning subsequent lines might need to be
	 * retokenized).
	 * @since jEdit 4.2pre6
	 */
public void setLineContext(TokenMarker.LineContext lineContext) {
    this.lineContext = lineContext;
}