/**
		Array index LHS Constructor.
	*/
 LHS(Object array, int index) {
    if (array == null)
        throw new NullPointerException("constructed empty LHS");
    type = INDEX;
    this.object = array;
    this.index = index;
}