public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    BSHAmbiguousName name = (BSHAmbiguousName) jjtGetChild(0);
    NameSpace namespace = callstack.top();
    namespace.setPackage(name.text);
    // import the package we're in by default...
    namespace.importPackage(name.text);
    return Primitive.VOID;
}