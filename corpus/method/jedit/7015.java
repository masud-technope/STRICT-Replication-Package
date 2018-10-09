//}}}
//}}}
//{{{ Screen line stuff
//{{{ getPhysicalLineOfScreenLine() method
/**
	 * Returns the physical line number that contains the specified screen
	 * line.
	 * @param screenLine The screen line
	 * @since jEdit 4.0pre6
	 */
public int getPhysicalLineOfScreenLine(int screenLine) {
    return chunkCache.getLineInfo(screenLine).physicalLine;
}