/**
		Set the returnTypeNode, paramsNode, and blockNode based on child
		node structure.  No evaluation is done here.
	*/
synchronized void insureNodesParsed() {
    if (// there is always a paramsNode
    paramsNode != null)
        return;
    Object firstNode = jjtGetChild(0);
    firstThrowsClause = 1;
    if (firstNode instanceof BSHReturnType) {
        returnTypeNode = (BSHReturnType) firstNode;
        paramsNode = (BSHFormalParameters) jjtGetChild(1);
        if (jjtGetNumChildren() > 2 + numThrows)
            // skip throws
            blockNode = (BSHBlock) jjtGetChild(2 + numThrows);
        ++firstThrowsClause;
    } else {
        paramsNode = (BSHFormalParameters) jjtGetChild(0);
        // skip throws
        blockNode = (BSHBlock) jjtGetChild(1 + numThrows);
    }
}