public static boolean hasObjectPropertyGetter(Class clas, String propName) {
    String getterName = accessorName("get", propName);
    try {
        clas.getMethod(getterName, new Class[0]);
        return true;
    } catch (NoSuchMethodException /* fall through */
    e) {
    }
    getterName = accessorName("is", propName);
    try {
        Method m = clas.getMethod(getterName, new Class[0]);
        return (m.getReturnType() == Boolean.TYPE);
    } catch (NoSuchMethodException e) {
        return false;
    }
}