public boolean imageUpdate(java.awt.Image img, int infoflags, int x, int y, int width, int height) {
    BshMethod method = null;
    try {
        method = namespace.getMethod("imageUpdate", new Class[] { null, null, null, null, null, null });
    } catch (UtilEvalError /*squeltch*/
    e) {
    }
    if (method != null)
        try {
            CallStack callstack = new CallStack(namespace);
            method.invoke(new Object[] { img, new Primitive(infoflags), new Primitive(x), new Primitive(y), new Primitive(width), new Primitive(height) }, declaringInterpreter, callstack, null);
        } catch (EvalError e) {
            declaringInterpreter.error("local event handler imageUpdate: method invocation error:" + e);
        }
    return true;
}