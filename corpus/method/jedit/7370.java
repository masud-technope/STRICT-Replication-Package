//}}}
//{{{ setStyles() method
/**
	 * Sets the syntax styles used to paint colorized text. Entry <i>n</i>
	 * will be used to paint tokens with id = <i>n</i>.
	 * @param styles The syntax styles
	 * @see org.gjt.sp.jedit.syntax.Token
	 */
public final void setStyles(SyntaxStyle[] styles) {
    this.styles = styles;
    styles[Token.NULL] = new SyntaxStyle(getForeground(), null, getFont());
    textArea.chunkCache.reset();
    repaint();
}