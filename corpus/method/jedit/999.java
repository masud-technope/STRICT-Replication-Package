/**
		@param overrideNamespace if set to true the block will be executed
		in the current namespace (not a subordinate one).
		<p>
		If true *no* new BlockNamespace will be swapped onto the stack and 
		the eval will happen in the current
		top namespace.  This is used by BshMethod, TryStatement, etc.  
		which must intialize the block first and also for those that perform 
		multiple passes in the same block.
	*/
public Object eval(CallStack callstack, Interpreter interpreter, boolean overrideNamespace) throws EvalError {
    Object syncValue = null;
    if (isSynchronized) {
        // First node is the expression on which to sync
        SimpleNode exp = ((SimpleNode) jjtGetChild(0));
        syncValue = exp.eval(callstack, interpreter);
    }
    Object ret;
    if (// Do the actual synchronization
    isSynchronized)
        synchronized (syncValue) {
            ret = evalBlock(callstack, interpreter, overrideNamespace/*filter*/
            , null);
        }
    else
        ret = evalBlock(callstack, interpreter, overrideNamespace/*filter*/
        , null);
    return ret;
}