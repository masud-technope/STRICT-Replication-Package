/**
	  * Creates an {@code ExtendedGridLayoutConstraints} object which can be
	  * used as placeholder for building a grid with colspans.
	  *
	  * @param forUsage If the returned object will be used in the grid
	  *                 and therefor the effectiveColspan should be raised by one
	  * @return The newly created {@code ExtendedGridLayoutConstraints}
	  *         object or {@code null} if no colspan is applicable
	  * @see #getRowspanPlaceholder(boolean)
	  */
ExtendedGridLayoutConstraints getColspanPlaceholder(boolean forUsage) {
    if (1 == colspan) {
        return null;
    }
    ExtendedGridLayoutConstraints result = new ExtendedGridLayoutConstraints(row, col + 1, colspan == REMAINDER ? REMAINDER : colspan - 1, rowspan, component, true, null == mainConstraints ? this : mainConstraints);
    if (forUsage && (result.mainConstraints.row == row)) {
        result.mainConstraints.effectiveColspan++;
    }
    return result;
}