public void set(String name, boolean value) throws EvalError {
    set(name, new Primitive(value));
}