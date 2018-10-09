private static void checkFoundStaticMethod(Method method, boolean staticOnly, Class clas) throws UtilEvalError {
    // We're looking for a static method but found an instance method
    if (method != null && staticOnly && !isStatic(method))
        throw new UtilEvalError("Cannot reach instance method: " + StringUtil.methodString(method.getName(), method.getParameterTypes()) + " from static context: " + clas.getName());
}