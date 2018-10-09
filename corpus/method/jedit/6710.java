//}}}
//{{{ isOutsideNarrowing() method
/**
	 * Returns true if the display is narrowed and the specified line is
	 * outside of the narrowing.
	 * @param line A physical line index
	 * @since jEdit 4.5
	 */
public boolean isOutsideNarrowing(int line) {
    if (line < getFirstVisibleLine())
        return true;
    // line.
    if (line > getLastVisibleLine()) {
        int lastVisible = getLastVisibleLine();
        int lastVisibleLevel = buffer.getFoldLevel(lastVisible);
        if (buffer.getFoldLevel(line) <= lastVisibleLevel)
            return true;
        // <= that of the last visible will break the root-child relationship
        for (int i = lastVisible + 1; i <= line; i++) {
            if (buffer.getFoldLevel(i) <= lastVisibleLevel)
                return true;
        }
        // fold-level root for the given line
        return false;
    }
    return false;
}