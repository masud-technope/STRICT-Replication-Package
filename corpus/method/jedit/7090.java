//}}}
//{{{ getBuffer() method
/**
	 * Returns the buffer this text area is editing.
	 * @since jedit 4.3pre3
	 *
	 *  Prior to 4.3pre3, this function returned a "Buffer" type.
	 *  If this causes your code to break, try calling view.getBuffer() instead of
	 *  view.getTextArea().getBuffer().
	 *
	 */
public final JEditBuffer getBuffer() {
    return buffer;
}