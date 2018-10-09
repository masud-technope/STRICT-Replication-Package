Object getClassInstance() throws UtilEvalError {
    if (classInstance != null)
        return classInstance;
    if (classStatic != null)
        throw new UtilEvalError("Can't refer to class instance from static context.");
    else
        throw new InterpreterError("Can't resolve class instance 'this' in: " + this);
}