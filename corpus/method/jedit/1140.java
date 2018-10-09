/**
		evaluate the type and one or more variable declarators, e.g.:
			int a, b=5, c;
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    try {
        NameSpace namespace = callstack.top();
        BSHType typeNode = getTypeNode();
        Class type = typeNode.getType(callstack, interpreter);
        BSHVariableDeclarator[] bvda = getDeclarators();
        for (int i = 0; i < bvda.length; i++) {
            BSHVariableDeclarator dec = bvda[i];
            // Type node is passed down the chain for array initializers
            // which need it under some circumstances
            Object value = dec.eval(typeNode, callstack, interpreter);
            try {
                namespace.setTypedVariable(dec.name, type, value, modifiers);
            } catch (UtilEvalError e) {
                throw e.toEvalError(this, callstack);
            }
        }
    } catch (EvalError e) {
        e.reThrow("Typed variable declaration");
    }
    return Primitive.VOID;
}