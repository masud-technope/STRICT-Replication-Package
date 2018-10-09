/**
		Used when accessibility capability is available to locate an occurrance
		of the field in the most derived class or superclass and set its 
		accessibility flag.
		Note that this method is not needed in the simple non accessible
		case because we don't have to hunt for fields.
		Note that classes may declare overlapping private fields, so the 
		distinction about the most derived is important.  Java doesn't normally
		allow this kind of access (super won't show private variables) so 
		there is no real syntax for specifying which class scope to use...

		@return the Field or throws NoSuchFieldException
		@throws NoSuchFieldException if the field is not found
	*/
/*
		This method should be rewritten to use getFields() and avoid catching
		exceptions during the search.
	*/
private static Field findAccessibleField(Class clas, String fieldName) throws UtilEvalError, NoSuchFieldException {
    Field field;
    // Quick check catches public fields include those in interfaces
    try {
        field = clas.getField(fieldName);
        ReflectManager.RMSetAccessible(field);
        return field;
    } catch (NoSuchFieldException e) {
    }
    // Now, on with the hunt...
    while (clas != null) {
        try {
            field = clas.getDeclaredField(fieldName);
            ReflectManager.RMSetAccessible(field);
            return field;
        // Not found, fall through to next class
        } catch (NoSuchFieldException e) {
        }
        clas = clas.getSuperclass();
    }
    throw new NoSuchFieldException(fieldName);
}