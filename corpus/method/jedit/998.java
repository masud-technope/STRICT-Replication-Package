Object evalBlock(CallStack callstack, Interpreter interpreter, boolean overrideNamespace, NodeFilter nodeFilter) throws EvalError {
    Object ret = Primitive.VOID;
    NameSpace enclosingNameSpace = null;
    if (!overrideNamespace) {
        enclosingNameSpace = callstack.top();
        BlockNameSpace bodyNameSpace = new BlockNameSpace(enclosingNameSpace);
        callstack.swap(bodyNameSpace);
    }
    int startChild = isSynchronized ? 1 : 0;
    int numChildren = jjtGetNumChildren();
    try {
        /*
				Evaluate block in two passes: 
				First do class declarations then do everything else.
			*/
        for (int i = startChild; i < numChildren; i++) {
            SimpleNode node = ((SimpleNode) jjtGetChild(i));
            if (nodeFilter != null && !nodeFilter.isVisible(node))
                continue;
            if (node instanceof BSHClassDeclaration)
                node.eval(callstack, interpreter);
        }
        for (int i = startChild; i < numChildren; i++) {
            SimpleNode node = ((SimpleNode) jjtGetChild(i));
            if (node instanceof BSHClassDeclaration)
                continue;
            // filter nodes
            if (nodeFilter != null && !nodeFilter.isVisible(node))
                continue;
            ret = node.eval(callstack, interpreter);
            // statement or embedded block evaluated a return statement
            if (ret instanceof ReturnControl)
                break;
        }
    } finally {
        // make sure we put the namespace back when we leave.
        if (!overrideNamespace)
            callstack.swap(enclosingNameSpace);
    }
    return ret;
}