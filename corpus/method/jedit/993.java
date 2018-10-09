/*
		object is a non-null and non-void Primitive type
	*/
private boolean isPrimitiveValue(Object obj) {
    return ((obj instanceof Primitive) && (obj != Primitive.VOID) && (obj != Primitive.NULL));
}