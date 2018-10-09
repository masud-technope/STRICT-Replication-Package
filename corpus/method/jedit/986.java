/**
		Construct the array from the initializer syntax.

		@param baseType the base class type of the array (no dimensionality)
		@param dimensions the top number of dimensions of the array 
			e.g. 2 for a String [][];
	*/
public Object eval(Class baseType, int dimensions, CallStack callstack, Interpreter interpreter) throws EvalError {
    int numInitializers = jjtGetNumChildren();
    // allocate the array to store the initializers
    // description of the array
    int[] dima = new int[dimensions];
    // The other dimensions default to zero and are assigned when 
    // the values are set.
    dima[0] = numInitializers;
    Object initializers = Array.newInstance(baseType, dima);
    // Evaluate the initializers
    for (int i = 0; i < numInitializers; i++) {
        SimpleNode node = (SimpleNode) jjtGetChild(i);
        Object currentInitializer;
        if (node instanceof BSHArrayInitializer) {
            if (dimensions < 2)
                throw new EvalError("Invalid Location for Intializer, position: " + i, this, callstack);
            currentInitializer = ((BSHArrayInitializer) node).eval(baseType, dimensions - 1, callstack, interpreter);
        } else
            currentInitializer = node.eval(callstack, interpreter);
        if (currentInitializer == Primitive.VOID)
            throw new EvalError("Void in array initializer, position" + i, this, callstack);
        // Determine if any conversion is necessary on the initializers.
        //
        // Quick test to see if conversions apply:
        // If the dimensionality of the array is 1 then the elements of
        // the initializer can be primitives or boxable types.  If it is
        // greater then the values must be array (object) types and there
        // are currently no conversions that we do on those.
        // If we have conversions on those in the future then we need to
        // get the real base type here instead of the dimensionless one.
        Object value = currentInitializer;
        if (dimensions == 1) {
            // the cast there when we tighten control
            try {
                value = Types.castObject(currentInitializer, baseType, Types.CAST);
            } catch (UtilEvalError e) {
                throw e.toEvalError("Error in array initializer", this, callstack);
            }
            // unwrap any primitive, map voids to null, etc.
            value = Primitive.unwrap(value);
        }
        // store the value in the array
        try {
            Array.set(initializers, i, value);
        } catch (IllegalArgumentException e) {
            Interpreter.debug("illegal arg" + e);
            throwTypeError(baseType, currentInitializer, i, callstack);
        } catch (ArrayStoreException // I think this can happen
        e) {
            Interpreter.debug("arraystore" + e);
            throwTypeError(baseType, currentInitializer, i, callstack);
        }
    }
    return initializers;
}