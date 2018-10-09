//}}}
//{{{ getFirstVisibleLine() method
/**
	 * Returns the physical line number of the first visible line.
	 * @since jEdit 4.2pre1
	 */
public int getFirstVisibleLine() {
    return folds.first();
}