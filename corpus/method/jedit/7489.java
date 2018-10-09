//}}}
//{{{ getBuffer() method
/**
	 * Returns the current edit pane's buffer.
	 * @return the current edit pane's buffer, it can be null
	 */
public Buffer getBuffer() {
    if (editPane == null)
        return null;
    else
        return editPane.getBuffer();
}