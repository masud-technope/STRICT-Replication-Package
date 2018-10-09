/**
	 * Returns the entire text of this text area.
	 */
public String getText() {
    return buffer.getText(0, buffer.getLength());
}