/**
	  * Creates an {@code ExtendedGridLayoutConstraints} object with
	  * all of its fields set to the passed-in arguments.
	  *
	  * @param row             The row in which a component starts its display area.
	  *                        First row is 0.
	  * @param col             The col in which a component starts its display area.
	  *                        First col is 0.
	  * @param colspan         The number of cells in a row for the component's display area.
	  *                        Use {@code REMAINDER} to specify that the component's
	  *                        display area will be from its grid position to the last
	  *                        cell in the row.
	  * @param rowspan         The number of cells in a column for the component's display area.
	  *                        Use {@code REMAINDER} to specify that the component's
	  *                        display area will be from its grid position to the last
	  *                        cell in the column.
	  * @param component       The {@code Component} this constraints object describes
	  * @param placeholder     If this constraints are used as placeholder to build the grid
	  * @param mainConstraints The mainConstraints object for which this constraints
	  *                        object is a placeholder
	  * @throws IllegalArgumentException If row {@literal < 0}
	  * @throws IllegalArgumentException If col {@literal < 0}
	  * @throws IllegalArgumentException If colspan {@literal < 1}
	  * @throws IllegalArgumentException If rowspan {@literal < 1}
	  */
private  ExtendedGridLayoutConstraints(int row, int col, int colspan, int rowspan, Component component, boolean placeholder, ExtendedGridLayoutConstraints mainConstraints) {
    if (row < 0) {
        throw new IllegalArgumentException("row must be non-negative (" + row + ')');
    }
    if (col < 0) {
        throw new IllegalArgumentException("col must be non-negative (" + col + ')');
    }
    if (colspan < 1) {
        throw new IllegalArgumentException("colspan must be at least 1 (" + colspan + ')');
    }
    if (rowspan < 1) {
        throw new IllegalArgumentException("rowspan must be at least 1 (" + rowspan + ')');
    }
    this.row = row;
    this.col = col;
    this.colspan = colspan;
    effectiveColspan = 1;
    this.rowspan = rowspan;
    effectiveRowspan = 1;
    this.component = component;
    this.placeholder = placeholder;
    this.mainConstraints = mainConstraints;
}