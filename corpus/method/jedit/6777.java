//}}}
//{{{ updateBorder() method
/**
	 * Sets the border differently if the text area has focus or not.
	 */
public void updateBorder() {
    if (textArea.hasFocus())
        setBorder(focusBorder);
    else
        setBorder(noFocusBorder);
}