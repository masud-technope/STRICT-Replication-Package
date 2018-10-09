//}}}
//{{{ getStart() method
/**
	 * Returns the beginning of the portion of the selection
	 * falling on the specified line. Used to manipulate
	 * selection text on a line-by-line basis.
	 * @param buffer The buffer
	 * @param line The line number
	 * @since jEdit 4.1pre1
	 */
public abstract int getStart(JEditBuffer buffer, int line);