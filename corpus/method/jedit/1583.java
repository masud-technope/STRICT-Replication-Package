/**
		Object field LHS Constructor.
	*/
 LHS(Object object, Field field) {
    if (object == null)
        throw new NullPointerException("constructed empty LHS");
    type = FIELD;
    this.object = object;
    this.field = field;
}