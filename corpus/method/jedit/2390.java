/**
		Attempt to cast an object instance to a new type if possible via
	 BeanShell extended syntax rules.  These rules are always a superset of
	 Java conversion rules.  If you wish to impose context sensitive
	 conversion rules then you must test before calling this method.
	 <p/>

		This method can handle fromValue Primitive types (representing
		primitive casts) as well as fromValue object casts requiring interface
		generation, etc.

		@param toType the class type of the cast result, which may include
		primitive types, e.g. Byte.TYPE

		@param fromValue an Object or bsh.Primitive primitive value (including
			Primitive.NULL or Primitive.VOID )

		@see #isBshAssignable( Class, Class )
	*/
public static Object castObject(Object fromValue, Class toType, int operation) throws UtilEvalError {
    if (fromValue == null)
        throw new InterpreterError("null fromValue");
    Class fromType = fromValue instanceof Primitive ? ((Primitive) fromValue).getType() : fromValue.getClass();
    return castObject(toType, fromType, fromValue, operation, /*checkonly*/
    false);
}