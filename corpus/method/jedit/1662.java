/*
        Get variables declared in this namespace.
    */
public Variable[] getDeclaredVariables() {
    if (variables == null)
        return new Variable[0];
    Variable[] vars = new Variable[variables.size()];
    int i = 0;
    for (Enumeration e = variables.elements(); e.hasMoreElements(); ) vars[i++] = (Variable) e.nextElement();
    return vars;
}