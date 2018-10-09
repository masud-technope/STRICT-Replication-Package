public void set(String name, long value) throws EvalError {
    set(name, new Primitive(value));
}