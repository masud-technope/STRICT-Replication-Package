/*
		Primary interpreter set and get variable methods
		Note: These are squeltching errors... should they?
	*/
/**
		Get the value of the name.
		name may be any value. e.g. a variable or field
	*/
public Object get(String name) throws EvalError {
    try {
        Object ret = globalNameSpace.get(name, this);
        return Primitive.unwrap(ret);
    } catch (UtilEvalError e) {
        throw e.toEvalError(SimpleNode.JAVACODE, new CallStack());
    }
}