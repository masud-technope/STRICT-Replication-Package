/**
		Determine if the type is assignable via Java boxing/unboxing rules.
	*/
static boolean isJavaBoxTypesAssignable(Class lhsType, Class rhsType) {
    // Assignment to loose type... defer to bsh extensions
    if (lhsType == null)
        return false;
    // prim can be boxed and assigned to Object
    if (lhsType == Object.class)
        return true;
    // prim numeric type can be boxed and assigned to number
    if (lhsType == Number.class && rhsType != Character.TYPE && rhsType != Boolean.TYPE)
        return true;
    // so this test is symmetric
    if (Primitive.wrapperMap.get(lhsType) == rhsType)
        return true;
    return false;
}