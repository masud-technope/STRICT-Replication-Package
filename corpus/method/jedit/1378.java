/**
		Place an unwrapped value in the external map.
		BeanShell primitive types are represented by their object wrappers, so
		it is not possible to differentiate between wrapper types and primitive
		types via the external Map.
	*/
protected void putExternalMap(String name, Object value) {
    if (value instanceof Variable)
        try {
            value = unwrapVariable((Variable) value);
        } catch (UtilEvalError ute) {
            throw new InterpreterError("unexpected UtilEvalError");
        }
    if (value instanceof Primitive)
        value = Primitive.unwrap((Primitive) value);
    externalMap.put(name, value);
}