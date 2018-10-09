/**
		Get the corresponding Java primitive TYPE class for this Primitive.
		@return the primitive TYPE class type of the value or Void.TYPE for
		Primitive.VOID or null value for type of Primitive.NULL
	*/
public Class getType() {
    if (this == Primitive.VOID)
        return Void.TYPE;
    // loose typing throughout bsh.
    if (this == Primitive.NULL)
        return null;
    return unboxType(value.getClass());
}