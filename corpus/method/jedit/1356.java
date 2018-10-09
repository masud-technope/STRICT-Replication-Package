/*
		Note: technically I think we could get by passing in only the
		current namespace or perhaps BshClassManager here instead of 
		CallStack and Interpreter.  However let's just play it safe in case
		of future changes - anywhere you eval a node you need these.
	*/
 DelayedEvalBshMethod(String name, String returnTypeDescriptor, BSHReturnType returnTypeNode, String[] paramNames, String[] paramTypeDescriptors, BSHFormalParameters paramTypesNode, BSHBlock methodBody, NameSpace declaringNameSpace, Modifiers modifiers, CallStack callstack, Interpreter interpreter) {
    super(name, /*returnType*/
    null, paramNames, /*paramTypes*/
    null, methodBody, declaringNameSpace, modifiers);
    this.returnTypeDescriptor = returnTypeDescriptor;
    this.returnTypeNode = returnTypeNode;
    this.paramTypeDescriptors = paramTypeDescriptors;
    this.paramTypesNode = paramTypesNode;
    this.callstack = callstack;
    this.interpreter = interpreter;
}