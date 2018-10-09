//}}}
//{{{ getText() method
/**
	 * Subclasses can override this to provide funky history behavior,
	 * for JTextPanes and such.
	 */
public String getText() {
    return text.getText();
}