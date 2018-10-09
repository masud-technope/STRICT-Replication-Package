//}}}
//{{{ getFoldLevel() method
/**
	 * Returns the fold level of the specified line.
	 * @param buffer The buffer in question
	 * @param lineIndex The line index
	 * @param seg A segment the fold handler can use to obtain any
	 * text from the buffer, if necessary
	 * @return The fold level of the specified line
	 * @since jEdit 4.0pre1
	 */
@Override
public int getFoldLevel(JEditBuffer buffer, int lineIndex, Segment seg) {
    return 0;
}