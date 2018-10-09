/**
        Load a command script from the input stream and find the BshMethod in
        the target namespace.
        @throws UtilEvalError on error in parsing the script or if the the
            method is not found after parsing the script.
    */
/*
        If we want to support multiple commands in the command path we need to
        change this to not throw the exception.
    */
private BshMethod loadScriptedCommand(InputStream in, String name, Class[] argTypes, String resourcePath, Interpreter interpreter) throws UtilEvalError {
    try {
        interpreter.eval(new InputStreamReader(in), this, resourcePath);
    } catch (EvalError e) {
        Interpreter.debug(e.toString());
        throw new UtilEvalError("Error loading script: " + e.getMessage());
    }
    // Look for the loaded command
    BshMethod meth = getMethod(name, argTypes);
    return meth;
}