/**
        @deprecated See #setTypedVariable( String, Class, Object, Modifiers )
    */
public void setTypedVariable(String name, Class type, Object value, boolean isFinal) throws UtilEvalError {
    Modifiers modifiers = new Modifiers();
    if (isFinal)
        modifiers.addModifier(Modifiers.FIELD, "final");
    setTypedVariable(name, type, value, modifiers);
}