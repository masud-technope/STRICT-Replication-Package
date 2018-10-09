private static ReflectError cantFindConstructor(Class clas, Class[] types) {
    if (types.length == 0)
        return new ReflectError("Can't find default constructor for: " + clas);
    else
        return new ReflectError("Can't find constructor: " + StringUtil.methodString(clas.getName(), types) + " in class: " + clas.getName());
}