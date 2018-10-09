public void set(String name, double value) throws EvalError {
    set(name, new Primitive(value));
}