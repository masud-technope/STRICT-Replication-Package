//}}}
//{{{ getTrueRow() method
/**
	 * Converts a row index from the JTable to an internal row index from the delegated model.
	 *
	 * @param rowIndex the row index
	 * @return the row index in the delegated model
	 */
public int getTrueRow(int rowIndex) {
    if (filteredIndices == null)
        return rowIndex;
    return filteredIndices.get(rowIndex).intValue();
}