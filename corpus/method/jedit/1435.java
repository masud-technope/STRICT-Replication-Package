public void set(String name, int value) throws EvalError {
    set(name, new Primitive(value));
}