/**
		Return a more human readable version of the type name.
		Specifically, array types are returned with postfix "[]" dimensions.
		e.g. return "int []" for integer array instead of "class [I" as
		would be returned by Class getName() in that case.
	*/
public static String normalizeClassName(Class type) {
    if (!type.isArray())
        return type.getName();
    StringBuilder className = new StringBuilder();
    try {
        className.append(getArrayBaseType(type).getName() + " ");
        for (int i = 0; i < getArrayDimensions(type); i++) className.append("[]");
    } catch (ReflectError e) {
    }
    return className.toString();
}