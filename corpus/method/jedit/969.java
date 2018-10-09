/**
		Create an array of the dimensions specified in dimensionsNode.
		dimensionsNode may contain a number of "undefined" as well as "defined"
		dimensions.
		<p>

		Background: in Java arrays are implemented in arrays-of-arrays style
		where, for example, a two dimensional array is a an array of arrays of
		some base type.  Each dimension-type has a Java class type associated 
		with it... so if foo = new int[5][5] then the type of foo is 
		int [][] and the type of foo[0] is int[], etc.  Arrays may also be 
		specified with undefined trailing dimensions - meaning that the lower 
		order arrays are not allocated as objects. e.g.  
		if foo = new int [5][]; then foo[0] == null //true; and can later be 
		assigned with the appropriate type, e.g. foo[0] = new int[5];
		(See Learning Java, O'Reilly & Associates more background).
		<p>

		To create an array with undefined trailing dimensions using the
		reflection API we must use an array type to represent the lower order
		(undefined) dimensions as the "base" type for the array creation... 
		Java will then create the correct type by adding the dimensions of the 
		base type to specified allocated dimensions yielding an array of
		dimensionality base + specified with the base dimensons unallocated.  
		To create the "base" array type we simply create a prototype, zero 
		length in each dimension, array and use it to get its class 
		(Actually, I think there is a way we could do it with Class.forName() 
		but I don't trust this).   The code is simpler than the explanation...
		see below.
	*/
private Object arrayNewInstance(Class type, BSHArrayDimensions dimensionsNode, CallStack callstack) throws EvalError {
    if (dimensionsNode.numUndefinedDims > 0) {
        Object proto = Array.newInstance(type, new int[// zeros
        dimensionsNode.numUndefinedDims]);
        type = proto.getClass();
    }
    try {
        return Array.newInstance(type, dimensionsNode.definedDimensions);
    } catch (NegativeArraySizeException e1) {
        throw new TargetError(e1, this, callstack);
    } catch (Exception e) {
        throw new EvalError("Can't construct primitive array: " + e.getMessage(), this, callstack);
    }
}