//}}}
//{{{ Getters and setters
//{{{ getStyles() method
/**
	 * Returns the syntax styles used to paint colorized text. Entry <i>n</i>
	 * will be used to paint tokens with id = <i>n</i>.
	 * @return an array of SyntaxStyles
	 * @see org.gjt.sp.jedit.syntax.Token
	 */
public final SyntaxStyle[] getStyles() {
    return styles;
}