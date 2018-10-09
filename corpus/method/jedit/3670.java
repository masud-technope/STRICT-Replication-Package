//}}}
//{{{ readNextChar() method
/**
	 * Invokes the specified BeanShell code, replacing __char__ in the
	 * code with the next input character.
	 * @param msg The prompt to display in the status bar
	 * @param code The code
	 * @since jEdit 3.2pre2
	 */
public void readNextChar(String msg, String code) {
    view.getStatus().setMessage(msg);
    readNextChar = code;
}