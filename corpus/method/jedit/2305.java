/**

		Returns the base type of an array Class.
    	throws ReflectError if the Class is not an array class.
	*/
public static Class getArrayBaseType(Class arrayClass) throws ReflectError {
    if (!arrayClass.isArray())
        throw new ReflectError("The class is not an array.");
    return arrayClass.getComponentType();
}