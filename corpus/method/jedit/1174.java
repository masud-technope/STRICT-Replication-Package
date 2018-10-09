public Class generateClass(String name, Modifiers modifiers, Class[] interfaces, Class superClass, BSHBlock block, boolean isInterface, CallStack callstack, Interpreter interpreter) throws EvalError {
    // Delegate to the static method
    return generateClassImpl(name, modifiers, interfaces, superClass, block, isInterface, callstack, interpreter);
}