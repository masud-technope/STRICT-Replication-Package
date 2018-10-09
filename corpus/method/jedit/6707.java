//}}}
//{{{ isLineVisible() method
/**
	 * Returns if the specified physical line is visible.
	 * @param line A physical line index
	 * @since jEdit 4.2pre1
	 */
public final boolean isLineVisible(int line) {
    return folds.search(line) % 2 == 0;
}