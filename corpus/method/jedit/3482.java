/**
	  * @return A work copy if this constraints object. This is a flat copy
	  *         which means that the reference to the component stays the same.
	  *         The returned object could be used without modifying this
	  *         constraints object.
	  */
ExtendedGridLayoutConstraints getWorkCopy() {
    return new ExtendedGridLayoutConstraints(row, col, colspan, rowspan, component, placeholder, (null == mainConstraints ? null : mainConstraints.getWorkCopy()));
}