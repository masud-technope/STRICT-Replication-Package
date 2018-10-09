/**
		Unwrap primitive values and map voids to nulls.
		Non Primitive types remain unchanged.

		@param obj object type which may be bsh.Primitive
		@return corresponding "normal" Java type, "unwrapping" 
			any bsh.Primitive types to their wrapper types.
	*/
public static Object unwrap(Object obj) {
    // map voids to nulls for the outside world
    if (obj == Primitive.VOID)
        return null;
    // unwrap primitives
    if (obj instanceof Primitive)
        return ((Primitive) obj).getValue();
    else
        return obj;
}