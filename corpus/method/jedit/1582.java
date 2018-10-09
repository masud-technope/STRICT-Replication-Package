public Object getValue() throws UtilEvalError {
    if (type == VARIABLE)
        return nameSpace.getVariable(varName);
    if (type == FIELD)
        try {
            Object o = field.get(object);
            return Primitive.wrap(o, field.getType());
        } catch (IllegalAccessException e2) {
            throw new UtilEvalError("Can't read field: " + field);
        }
    if (type == PROPERTY)
        try {
            return Reflect.getObjectProperty(object, propName);
        } catch (ReflectError e) {
            Interpreter.debug(e.getMessage());
            throw new UtilEvalError("No such property: " + propName);
        }
    if (type == INDEX)
        try {
            return Reflect.getIndex(object, index);
        } catch (Exception e) {
            throw new UtilEvalError("Array access: " + e);
        }
    throw new InterpreterError("LHS type");
}