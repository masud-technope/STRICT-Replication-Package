/**
		Wrap primitive values (as indicated by type param) and nulls in the 
		Primitive class.  Values not primitive or null are left unchanged.
		Primitive values are represented by their wrapped values in param value.
		<p>
		The value null is mapped to Primitive.NULL.
		Any value specified with type Void.TYPE is mapped to Primitive.VOID.
	*/
public static Object wrap(Object value, Class type) {
    if (type == Void.TYPE)
        return Primitive.VOID;
    if (value == null)
        return Primitive.NULL;
    if (type.isPrimitive())
        return new Primitive(value);
    return value;
}