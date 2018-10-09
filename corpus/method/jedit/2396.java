/**
        Re-throw as an eval error, prefixing msg to the message and specifying
        the node.  If a node already exists the addNode is ignored.
        <p>
        @param msg may be null for no additional message.
    */
public EvalError toEvalError(String msg, SimpleNode node, CallStack callstack) {
    if (Interpreter.DEBUG)
        printStackTrace();
    if (msg == null)
        msg = "";
    else
        msg = msg + ": ";
    return new EvalError(msg + getMessage(), node, callstack);
}