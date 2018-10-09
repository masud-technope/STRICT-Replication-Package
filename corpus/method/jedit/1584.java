/**
		Object property LHS Constructor.
	*/
 LHS(Object object, String propName) {
    if (object == null)
        throw new NullPointerException("constructed empty LHS");
    type = PROPERTY;
    this.object = object;
    this.propName = propName;
}