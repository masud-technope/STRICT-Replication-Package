public String getScriptStackTrace() {
    if (callstack == null)
        return "<Unknown>";
    String trace = "";
    CallStack stack = callstack.copy();
    while (stack.depth() > 0) {
        NameSpace ns = stack.pop();
        SimpleNode node = ns.getNode();
        if (ns.isMethod) {
            trace = trace + "\nCalled from method: " + ns.getName();
            if (node != null)
                trace += " : at Line: " + node.getLineNumber() + " : in file: " + node.getSourceFile() + " : " + node.getText();
        }
    }
    return trace;
}