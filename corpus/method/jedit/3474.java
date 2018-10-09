/**
	  * Creates an {@code ExtendedGridLayoutConstraints} object which can be
	  * used as placeholder for building a grid with rowspans.
	  *
	  * @param forUsage If the returned object will be used in the grid
	  *                 and therefor the effectiveRowspan should be raised by one
	  * @return The newly created {@code ExtendedGridLayoutConstraints}
	  *         object or {@code null} if no rowspan is applicable
	  * @see #getColspanPlaceholder(boolean)
	  */
ExtendedGridLayoutConstraints getRowspanPlaceholder(boolean forUsage) {
    if (1 == rowspan) {
        return null;
    }
    ExtendedGridLayoutConstraints result = new ExtendedGridLayoutConstraints(row + 1, col, colspan, rowspan == REMAINDER ? REMAINDER : rowspan - 1, component, true, null == mainConstraints ? this : mainConstraints);
    if (forUsage && (result.mainConstraints.col == col)) {
        result.mainConstraints.effectiveRowspan++;
    }
    return result;
}