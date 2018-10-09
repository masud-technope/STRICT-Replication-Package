//{{{ recordInput() method
/**
		 * @since jEdit 4.2pre5
		 */
public void recordInput(int repeat, char ch, boolean overwrite) {
    // can take place
    if (ch == '\n')
        record(repeat, "textArea.userInput(\'\\n\');");
    else if (ch == '\t')
        record(repeat, "textArea.userInput(\'\\t\');");
    else {
        StringBuilder buf = new StringBuilder(repeat);
        for (int i = 0; i < repeat; i++) buf.append(ch);
        recordInput(buf.toString(), overwrite);
    }
//}}}
}