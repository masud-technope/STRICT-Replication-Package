/**
		Return a UtilEvalError or UtilTargetError wrapping a ClassCastException
		describing an illegal assignment or illegal cast, respectively.	
	*/
static UtilEvalError castError(Class lhsType, Class rhsType, int operation) {
    return castError(Reflect.normalizeClassName(lhsType), Reflect.normalizeClassName(rhsType), operation);
}