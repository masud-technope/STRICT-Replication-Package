protected Variable getImportedVar(String name) throws UtilEvalError {
    // Try object imports
    if (importedObjects != null)
        for (int i = 0; i < importedObjects.size(); i++) {
            Object object = importedObjects.elementAt(i);
            Class clas = object.getClass();
            Field field = Reflect.resolveJavaField(clas, name, false);
            if (field != null)
                return new Variable(name, field.getType(), new LHS(object, field));
        }
    // Try static imports
    if (importedStatic != null)
        for (int i = 0; i < importedStatic.size(); i++) {
            Class clas = (Class) importedStatic.elementAt(i);
            Field field = Reflect.resolveJavaField(clas, name, true);
            if (field != null)
                return new Variable(name, field.getType(), new LHS(field));
        }
    return null;
}