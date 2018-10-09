/**
        Helper for implementing NameSource
    */
protected void getAllNamesAux(Vector vec) {
    Enumeration varNames = variables.keys();
    while (varNames.hasMoreElements()) vec.addElement(varNames.nextElement());
    Enumeration methodNames = methods.keys();
    while (methodNames.hasMoreElements()) vec.addElement(methodNames.nextElement());
    if (parent != null)
        parent.getAllNamesAux(vec);
}