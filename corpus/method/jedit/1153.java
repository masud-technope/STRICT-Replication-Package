public NameSpace pop() {
    if (depth() < 1)
        throw new InterpreterError("pop on empty CallStack");
    NameSpace top = top();
    stack.removeElementAt(0);
    return top;
}