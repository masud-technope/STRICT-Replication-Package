//}}}
//{{{ getLineInfo() method
/**
	 * Returns the line informations for a given screen line or a non-null
	 * new LineInfo if the requested <code>screenLine</code> is out of range.
	 * @param screenLine the screen line
	 * @return the LineInfo for the screenLine
	 */
LineInfo getLineInfo(int screenLine) {
    if (screenLine >= lineInfo.length)
        return new LineInfo();
    updateChunksUpTo(screenLine);
    return lineInfo[screenLine];
}