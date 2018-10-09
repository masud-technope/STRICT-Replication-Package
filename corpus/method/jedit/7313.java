//}}}
//{{{ paintValidLine() method
/**
	 * Called by the text area when the extension is to paint a
	 * screen line which has an associated physical line number in
	 * the buffer. Note that since one physical line may consist of
	 * several screen lines due to soft wrap, the start and end
	 * offsets of the screen line are passed in as well.
	 *
	 * @param gfx The graphics context
	 * @param screenLine The screen line number
	 * @param physicalLine The physical line number
	 * @param start The offset where the screen line begins, from
	 * the start of the buffer
	 * @param end The offset where the screen line ends, from the
	 * start of the buffer
	 * @param y The y co-ordinate of the top of the line's
	 * bounding box
	 * @since jEdit 4.0pre4
	 */
public void paintValidLine(Graphics2D gfx, int screenLine, //}}}
int physicalLine, //}}}
int start, //}}}
int end, //}}}
int y) //}}}
{
}