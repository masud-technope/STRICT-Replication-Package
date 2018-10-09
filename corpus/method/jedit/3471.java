/**
	  * Creates an {@code ExtendedGridLayoutConstraints} object with
	  * all of its fields set to the passed-in arguments.
	  *
	  * @param row       The row in which a component starts its display area.
	  *                  First row is 0. Default value is 0.
	  * @param colspan   The number of cells in a row for the component's display area.
	  *                  Use {@code REMAINDER} to specify that the component's
	  *                  display area will be from its grid position to the last
	  *                  cell in the row. Default value is 1.
	  * @param rowspan   The number of cells in a column for the component's display area.
	  *                  Use {@code REMAINDER} to specify that the component's
	  *                  display area will be from its grid position to the last
	  *                  cell in the column. Default value is 1.
	  * @param component The {@code Component} this constraints object describes
	  * @throws IllegalArgumentException If row {@literal < 0}
	  * @throws IllegalArgumentException If colspan {@literal < 1}
	  * @throws IllegalArgumentException If rowspan {@literal < 1}
	  */
public  ExtendedGridLayoutConstraints(int row, int colspan, int rowspan, Component component) {
    this(row, 0, colspan, rowspan, component, false, null);
}