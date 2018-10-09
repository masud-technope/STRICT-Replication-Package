/**
		Static field LHS Constructor.
		This simply calls Object field constructor with null object.
	*/
 LHS(Field field) {
    type = FIELD;
    this.object = null;
    this.field = field;
}