public  EvalError(String s, SimpleNode node, CallStack callstack) {
    setMessage(s);
    this.node = node;
    // freeze the callstack for the stack trace.
    if (callstack != null)
        this.callstack = callstack.copy();
}