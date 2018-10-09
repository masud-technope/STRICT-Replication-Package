/**
		Determine if this primitive is a numeric type.
		i.e. not boolean, null, or void (but including char)
	*/
public boolean isNumber() {
    return (!(value instanceof Boolean) && !(this == NULL) && !(this == VOID));
}