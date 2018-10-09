//}}}
//{{{ setScreenLineCount() method
/**
	 * Sets the number of screen lines that the specified physical line
	 * is split into.
	 * @param line the physical line number
	 * @param count the line count (1 if no wrap)
	 */
void setScreenLineCount(int line, int count) {
    assert count > 0 : "New line count is bogus!";
    if (count > Short.MAX_VALUE) {
        // limitations...
        count = Short.MAX_VALUE;
        Log.log(Log.ERROR, this, new Exception("Max screen line count hit!"));
    }
    if (Debug.SCREEN_LINES_DEBUG)
        Log.log(Log.DEBUG, this, new Exception("setScreenLineCount(" + line + ',' + count + ')'));
    if (screenLines == null)
        reset();
    screenLines[line] = (char) count;
}