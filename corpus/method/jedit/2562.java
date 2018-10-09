//}}}
//{{{ isFoldEnd() method
/**
	 * @return if the specified line ends a fold.
	 * @param line the line
	 * @since jEdit 4.2pre5
	 */
public boolean isFoldEnd(int line) {
    int foldLevel = getFoldLevel(line);
    int nextLineFoldLevel = line == getLineCount() - 1 ? 0 : getFoldLevel(line + 1);
    return foldLevel > nextLineFoldLevel;
}