/**
		returns the dimensionality of the Class
		returns 0 if the Class is not an array class
	*/
public static int getArrayDimensions(Class arrayClass) {
    if (!arrayClass.isArray())
        return 0;
    // why so cute?
    return arrayClass.getName().lastIndexOf('[') + 1;
}