/**
		@throws ReflectError if the field is not found.
	*/
/*
		Note: this should really just throw NoSuchFieldException... need
		to change related signatures and code.
	*/
protected static Field resolveExpectedJavaField(Class clas, String fieldName, boolean staticOnly) throws UtilEvalError, ReflectError {
    Field field;
    try {
        if (Capabilities.haveAccessibility())
            field = findAccessibleField(clas, fieldName);
        else
            // Class getField() finds only public (and in interfaces, etc.)
            field = clas.getField(fieldName);
    } catch (NoSuchFieldException e) {
        throw new ReflectError("No such field: " + fieldName);
    } catch (SecurityException e) {
        throw new UtilTargetError("Security Exception while searching fields of: " + clas, e);
    }
    if (staticOnly && !Modifier.isStatic(field.getModifiers()))
        throw new UtilEvalError("Can't reach instance field: " + fieldName + " from static context: " + clas.getName());
    return field;
}