/**
		Override toEvalError to throw TargetError type.
	*/
public EvalError toEvalError(String msg, SimpleNode node, CallStack callstack) {
    if (msg == null)
        msg = getMessage();
    else
        msg = msg + ": " + getMessage();
    return new TargetError(msg, t, node, callstack, false);
}