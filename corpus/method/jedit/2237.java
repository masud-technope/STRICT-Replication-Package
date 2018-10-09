/**
		Get the appropriate default value per JLS 4.5.4
	*/
public static Primitive getDefaultValue(Class type) {
    if (type == null || !type.isPrimitive())
        return Primitive.NULL;
    if (type == Boolean.TYPE)
        return new Primitive(false);
    // non boolean primitive, get appropriate flavor of zero
    try {
        return new Primitive((int) 0).castToType(type, Types.CAST);
    } catch (UtilEvalError e) {
        throw new InterpreterError("bad cast");
    }
}