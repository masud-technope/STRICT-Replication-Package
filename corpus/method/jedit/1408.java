public static void invokeMain(Class clas, String[] args) throws Exception {
    Method main = Reflect.resolveJavaMethod(/*BshClassManager*/
    null, clas, "main", new Class[] { String[].class }, /*onlyStatic*/
    true);
    if (main != null)
        main.invoke(null, new Object[] { args });
}