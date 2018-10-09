/**
	  * Creates an {@code ExtendedGridLayoutConstraints} object with
	  * all of its fields set to their default value
	  * except of the row which is specified. For further information
	  * about the default values see
	  * {@link #ExtendedGridLayoutConstraints(int, int, int, java.awt.Component)}.
	  *
	  * @param row       The row in which a component starts its display area. First row is 0
	  * @param component The {@code Component} this constraints object d describes
	  * @throws IllegalArgumentException If row {@literal < 0}
	  */
public  ExtendedGridLayoutConstraints(int row, Component component) {
    this(row, 0, 1, 1, component, false, null);
}