/**
		Does the type descriptor string describe a primitive type?
	*/
private static boolean isPrimitive(String typeDescriptor) {
    // right?
    return typeDescriptor.length() == 1;
}