//}}}
//{{{ getScreenLineCount() method
/**
	 * Returns how many screen lines contains the given physical line.
	 * It can be greater than 1 when using soft wrap
	 *
	 * @param line the physical line
	 * @return the screen line count
	 */
int getScreenLineCount(int line) {
    assert isScreenLineCountValid(line);
    return screenLines[line];
}