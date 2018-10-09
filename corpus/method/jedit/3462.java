/**
	  * Retrieves the constraints for the specified {@code component}.
	  * If {@code component} is not in the {@code ExtendedGridLayout},
	  * a set of default {@code ExtendedGridLayoutConstraints} are returned.
	  *
	  * @param component the {@code component} to be queried
	  * @return the contraints for the specified {@code component}
	  * @throws NullPointerException if {@code component} is {@code null}
	  * @see ExtendedGridLayoutConstraints
	  */
private ExtendedGridLayoutConstraints lookupConstraints(Component component) {
    if (null == component) {
        throw new NullPointerException("component must not be null");
    }
    ExtendedGridLayoutConstraints constraints = comptable.get(component);
    if (null == constraints) {
        constraints = new ExtendedGridLayoutConstraints(component);
        comptable.put(component, constraints);
    }
    return constraints;
}