/**
    */
public void setTypedVariable(String name, Class type, Object value, Modifiers modifiers) throws UtilEvalError {
    super.setTypedVariable(name, type, value, modifiers);
    putExternalMap(name, value);
}