/**
	  * Creates an {@code ExtendedGridLayoutConstraints} object with
	  * all of its fields set to their default value. For further information
	  * about the default values see
	  * {@link #ExtendedGridLayoutConstraints(int, int, int, java.awt.Component)}.
	  *
	  * @param component The {@code Component} this constraints object describes
	  */
public  ExtendedGridLayoutConstraints(Component component) {
    this(0, 0, 1, 1, component, false, null);
}