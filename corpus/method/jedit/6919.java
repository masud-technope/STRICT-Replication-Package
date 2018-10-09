//}}}
//{{{ getEnd() method
/**
	 * Returns the end of the portion of the selection
	 * falling on the specified line. Used to manipulate
	 * selection text on a line-by-line basis.
	 * @param buffer The buffer
	 * @param line The line number
	 * @since jEdit 4.1pre1
	 */
public abstract int getEnd(JEditBuffer buffer, int line);