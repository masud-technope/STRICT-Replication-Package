public static boolean hasObjectPropertySetter(Class clas, String propName) {
    String setterName = accessorName("set", propName);
    Method[] methods = clas.getMethods();
    // has at least one setter of the right name?
    for (int i = 0; i < methods.length; i++) if (methods[i].getName().equals(setterName))
        return true;
    return false;
}