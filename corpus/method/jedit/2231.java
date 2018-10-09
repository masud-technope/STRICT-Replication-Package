/**
		Cast this bsh.Primitive value to a new bsh.Primitive value
		This is usually a numeric type cast.  Other cases include:
			A boolean can be cast to boolen
			null can be cast to any object type and remains null
			Attempting to cast a void causes an exception
		@param toType is the java object or primitive TYPE class
	*/
public Primitive castToType(Class toType, int operation) throws UtilEvalError {
    return castPrimitive(toType, /*fromType*/
    getType(), /*fromValue*/
    this, /*checkOnly*/
    false, operation);
}