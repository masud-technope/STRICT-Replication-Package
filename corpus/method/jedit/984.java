/**
		Evaluate the structure of the array in one of two ways:

			a) an initializer exists, evaluate it and return
			the fully constructed array object, also record the dimensions
			of that array
			
			b) evaluate and record the lengths in each dimension and 
			return void.

		The structure of the array dims is maintained in dimensions.
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    SimpleNode child = (SimpleNode) jjtGetChild(0);
    /*
			Child is array initializer.  Evaluate it and fill in the 
			dimensions it returns.  Initialized arrays are always fully defined
			(no undefined dimensions to worry about).  
			The syntax uses the undefinedDimension count.
			e.g. int [][] { 1, 2 };
		*/
    if (child instanceof BSHArrayInitializer) {
        if (baseType == null)
            throw new EvalError("Internal Array Eval err:  unknown base type", this, callstack);
        Object initValue = ((BSHArrayInitializer) child).eval(baseType, numUndefinedDims, callstack, interpreter);
        Class arrayClass = initValue.getClass();
        int actualDimensions = Reflect.getArrayDimensions(arrayClass);
        definedDimensions = new int[actualDimensions];
        // number specified (syntax uses the undefined ones here)
        if (definedDimensions.length != numUndefinedDims)
            throw new EvalError("Incompatible initializer. Allocation calls for a " + numUndefinedDims + " dimensional array, but initializer is a " + actualDimensions + " dimensional array", this, callstack);
        // fill in definedDimensions [] lengths
        Object arraySlice = initValue;
        for (int i = 0; i < definedDimensions.length; i++) {
            definedDimensions[i] = Array.getLength(arraySlice);
            if (definedDimensions[i] > 0)
                arraySlice = Array.get(arraySlice, 0);
        }
        return initValue;
    } else // Evaluate the defined dimensions of the array
    {
        definedDimensions = new int[numDefinedDims];
        for (int i = 0; i < numDefinedDims; i++) {
            try {
                Object length = ((SimpleNode) jjtGetChild(i)).eval(callstack, interpreter);
                definedDimensions[i] = ((Primitive) length).intValue();
            } catch (Exception e) {
                throw new EvalError("Array index: " + i + " does not evaluate to an integer", this, callstack);
            }
        }
    }
    return Primitive.VOID;
}