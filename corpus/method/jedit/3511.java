//}}}
//{{{ getInternal2ExternalRow() method
/**
	 * Converts a row index from the delegated table model into a row index of the JTable.
	 *
	 * @param internalRowIndex the internal row index
	 * @return the table row index or -1 if this row is not visible
	 */
public int getInternal2ExternalRow(int internalRowIndex) {
    if (invertedIndices == null)
        return internalRowIndex;
    Integer externalRowIndex = invertedIndices.get(internalRowIndex);
    if (externalRowIndex == null)
        return -1;
    return externalRowIndex.intValue();
}