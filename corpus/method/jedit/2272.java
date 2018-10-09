// private to prevent invocation with param that isn't a primitive-wrapper
public  Primitive(Object value) {
    if (value == null)
        throw new InterpreterError("Use Primitve.NULL instead of Primitive(null)");
    if (value != Special.NULL_VALUE && value != Special.VOID_TYPE && !isWrapperType(value.getClass()))
        throw new InterpreterError("Not a wrapper type: " + value);
    this.value = value;
}