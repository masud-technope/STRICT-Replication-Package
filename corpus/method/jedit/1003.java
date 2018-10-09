/**
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    int child = 0;
    // resolve superclass if any
    Class superClass = null;
    if (extend) {
        BSHAmbiguousName superNode = (BSHAmbiguousName) jjtGetChild(child++);
        superClass = superNode.toClass(callstack, interpreter);
    }
    // Get interfaces
    Class[] interfaces = new Class[numInterfaces];
    for (int i = 0; i < numInterfaces; i++) {
        BSHAmbiguousName node = (BSHAmbiguousName) jjtGetChild(child++);
        interfaces[i] = node.toClass(callstack, interpreter);
        if (!interfaces[i].isInterface())
            throw new EvalError("Type: " + node.text + " is not an interface!", this, callstack);
    }
    BSHBlock block;
    // Get the class body BSHBlock
    if (child < jjtGetNumChildren())
        block = (BSHBlock) jjtGetChild(child);
    else
        block = new BSHBlock(ParserTreeConstants.JJTBLOCK);
    try {
        return ClassGenerator.getClassGenerator().generateClass(name, modifiers, interfaces, superClass, block, isInterface, callstack, interpreter);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}