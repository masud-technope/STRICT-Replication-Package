//}}}
//{{{ getLastVisibleLine() method
/**
	 * Returns the physical line number of the last visible line.
	 * @since jEdit 4.2pre1
	 */
public int getLastVisibleLine() {
    return folds.last();
}