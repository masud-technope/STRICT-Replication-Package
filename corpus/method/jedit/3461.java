/**
	  * Adds the specified component to the layout, using the specified
	  * constraints object.
	  *
	  * @param component    The component to be added
	  * @param constraints  Where/how the component is added to the layout.
	  * @throws IllegalArgumentException if {@code constraints} is not an ExtendedGridLayoutConstraints object
	  * @throws IllegalArgumentException if {@code constraints} is a placeholder
	  * @throws IllegalArgumentException if {@code constraints} is not the right one for the component
	  * @see ExtendedGridLayoutConstraints
	  */
public void addLayoutComponent(Component component, Object constraints) {
    if (null == constraints) {
        constraints = new ExtendedGridLayoutConstraints(component);
    }
    if (constraints instanceof ExtendedGridLayoutConstraints) {
        ExtendedGridLayoutConstraints eglConstraints = (ExtendedGridLayoutConstraints) constraints;
        if (eglConstraints.isPlaceholder()) {
            throw new IllegalArgumentException("constraints must not be a placeholder");
        } else if (component != eglConstraints.getComponent()) {
            throw new IllegalArgumentException("constraints is not the right one for this component");
        }
        comptable.put(component, eglConstraints);
    } else {
        throw new IllegalArgumentException("constraints must not be an ExtendedGridLayoutConstraints object");
    }
}