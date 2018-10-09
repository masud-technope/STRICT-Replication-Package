//}}}
//{{{ setText() method
/**
	 * Sets the entire text of this text area.
	 * @param text the new content of the buffer
	 */
public void setText(String text) {
    try {
        buffer.beginCompoundEdit();
        buffer.remove(0, buffer.getLength());
        buffer.insert(0, text);
    } finally {
        buffer.endCompoundEdit();
    }
}