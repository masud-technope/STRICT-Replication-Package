//}}}
//{{{ setText() method
/**
	 * Subclasses can override this to provide funky history behavior,
	 * for JTextPanes and such.
	 */
public void setText(String text) {
    this.index = -1;
    this.text.setText(text);
}