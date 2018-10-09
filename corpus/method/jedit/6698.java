//}}}
//{{{ expandFold() method
/**
	 * Expands the fold at the specified physical line index.
	 * @param line A physical line index
	 * @param fully If true, all subfolds will also be expanded
	 * @return the line number of the first subfold, or -1 if none
	 * @since jEdit 4.2pre1
	 */
public int expandFold(int line, boolean fully) {
    MutableInteger firstSubfold = new MutableInteger(-1);
    boolean unfolded = _expandFold(line, fully, firstSubfold);
    if (unfolded)
        textArea.foldStructureChanged();
    return firstSubfold.get();
}