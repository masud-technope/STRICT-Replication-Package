private Object constructWithClassBody(Class type, Object[] args, BSHBlock block, CallStack callstack, Interpreter interpreter) throws EvalError {
    String name = callstack.top().getName() + "$" + (++innerClassCount);
    Modifiers modifiers = new Modifiers();
    modifiers.addModifier(Modifiers.CLASS, "public");
    Class clas;
    try {
        clas = ClassGenerator.getClassGenerator().generateClass(name, /*interfaces*/
        modifiers, null, /*superClass*/
        type, /*isInterface*/
        block, false, callstack, interpreter);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
    try {
        return Reflect.constructObject(clas, args);
    } catch (Exception e) {
        if (e instanceof InvocationTargetException)
            e = (Exception) ((InvocationTargetException) e).getTargetException();
        throw new EvalError("Error constructing inner class instance: " + e, this, callstack);
    }
}