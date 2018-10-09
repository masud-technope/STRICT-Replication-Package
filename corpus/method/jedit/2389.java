/**
	 Perform a type conversion or test if a type conversion is possible with
	 respect to BeanShell extended rules.  These rules are always a superset of
	 the Java language rules, so this method can also perform (but not test)
	 any Java language assignment or cast conversion.
	 <p/>

	 This method can perform the functionality of testing if an assignment
	 or cast is ultimately possible (with respect to BeanShell) as well as the
	 functionality of performing the necessary conversion of a value based
	 on the specified target type.  This combined functionality is done for
	 expediency and could be separated later.
	 <p/>

	 Other methods such as isJavaAssignable() should be used to determine the
	 suitability of an assignment in a fine grained or restrictive way based
	 on context before calling this method
	 <p/>

	 A CAST is stronger than an ASSIGNMENT operation in that it will attempt to
	 perform primtive operations that cast to a smaller type. e.g. (byte)myLong;
	 These are used in explicit primitive casts, primitive delclarations and
	 array declarations. I don't believe there are any object conversions which are
	 different between  ASSIGNMENT and CAST (e.g. scripted object to interface proxy
	 in bsh is done on assignment as well as cast).
	 <p/>

	 This method does not obey strictJava(), you must test first before
	 using this method if you care. (See #isJavaAssignable()).
	 <p/>

		@param toType the class type of the cast result, which may include
			primitive types, e.g. Byte.TYPE.  toType may be null to indicate a
			loose type assignment (which matches any fromType).

		@param fromType is the class type of the value to be cast including
			java primitive TYPE classes for primitives.
			If fromValue is (or would be) Primitive.NULL then fromType should be null.

		@param fromValue an Object or bsh.Primitive primitive value (including
			Primitive.NULL or Primitive.VOID )

		@param checkOnly If checkOnly is true then fromValue must be null.
			FromType is checked for the cast to toType...
			If checkOnly is false then fromValue must be non-null
			(Primitive.NULL is ok) and the actual cast is performed.

		@throws UtilEvalError on invalid assignment (when operation is
			assignment ).

		@throws UtilTargetError wrapping ClassCastException on cast error
			(when operation is cast)

		@param operation is Types.CAST or Types.ASSIGNMENT

		@see org.gjt.sp.jedit.bsh.Primitive.getType()
	*/
/*
		Notes: This method is currently responsible for auto-boxing/unboxing
		conversions...  Where does that need to go?
	*/
private static Object castObject(Class toType, Class fromType, Object fromValue, int operation, boolean checkOnly) throws UtilEvalError {
    /*
			Lots of preconditions checked here...
			Once things are running smoothly we might comment these out
			(That's what assertions are for).
		*/
    if (checkOnly && fromValue != null)
        throw new InterpreterError("bad cast params 1");
    if (!checkOnly && fromValue == null)
        throw new InterpreterError("bad cast params 2");
    if (fromType == Primitive.class)
        throw new InterpreterError("bad from Type, need to unwrap");
    if (fromValue == Primitive.NULL && fromType != null)
        throw new InterpreterError("inconsistent args 1");
    if (fromValue == Primitive.VOID && fromType != Void.TYPE)
        throw new InterpreterError("inconsistent args 2");
    if (toType == Void.TYPE)
        throw new InterpreterError("loose toType should be null");
    // assignment to loose type, void type, or exactly same type
    if (toType == null || toType == fromType)
        return checkOnly ? VALID_CAST : fromValue;
    // Casting to primitive type
    if (toType.isPrimitive()) {
        if (fromType == Void.TYPE || fromType == null || fromType.isPrimitive()) {
            // Both primitives, do primitive cast
            return Primitive.castPrimitive(toType, fromType, (Primitive) fromValue, checkOnly, operation);
        } else {
            if (Primitive.isWrapperType(fromType)) {
                // wrapper to primitive
                // Convert value to Primitive and check/cast it.
                //Object r = checkOnly ? VALID_CAST :
                Class unboxedFromType = Primitive.unboxType(fromType);
                Primitive primFromValue;
                if (checkOnly)
                    // must be null in checkOnly
                    primFromValue = null;
                else
                    primFromValue = (Primitive) Primitive.wrap(fromValue, unboxedFromType);
                return Primitive.castPrimitive(toType, unboxedFromType, primFromValue, checkOnly, operation);
            } else {
                // Cannot cast from arbitrary object to primitive
                if (checkOnly)
                    return INVALID_CAST;
                else
                    throw castError(toType, fromType, operation);
            }
        }
    }
    // Casting from primitive or void (to reference type)
    if (fromType == Void.TYPE || fromType == null || fromType.isPrimitive()) {
        // cast from primitive to wrapper type
        if (Primitive.isWrapperType(toType) && fromType != Void.TYPE && fromType != null) {
            // primitive to wrapper type
            return checkOnly ? VALID_CAST : Primitive.castWrapper(Primitive.unboxType(toType), ((Primitive) fromValue).getValue());
        }
        // Primitive (not null or void) to Object.class type
        if (toType == Object.class && fromType != Void.TYPE && fromType != null) {
            // box it
            return checkOnly ? VALID_CAST : ((Primitive) fromValue).getValue();
        }
        // Primitive.NULL and Primitive.VOID
        return Primitive.castPrimitive(toType, fromType, (Primitive) fromValue, checkOnly, operation);
    }
    // e.g cast Primitive.Void to Object would pass this
    if (toType.isAssignableFrom(fromType))
        return checkOnly ? VALID_CAST : fromValue;
    // the correct interface?
    if (toType.isInterface() && org.gjt.sp.jedit.bsh.This.class.isAssignableFrom(fromType) && Capabilities.canGenerateInterfaces())
        return checkOnly ? VALID_CAST : ((org.gjt.sp.jedit.bsh.This) fromValue).getInterface(toType);
    // Try numeric style promotion wrapper cast
    if (Primitive.isWrapperType(toType) && Primitive.isWrapperType(fromType))
        return checkOnly ? VALID_CAST : Primitive.castWrapper(toType, fromValue);
    if (checkOnly)
        return INVALID_CAST;
    else
        throw castError(toType, fromType, operation);
}