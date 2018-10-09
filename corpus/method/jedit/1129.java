public static String getTypeDescriptor(Class clas) {
    if (clas == Boolean.TYPE)
        return "Z";
    if (clas == Character.TYPE)
        return "C";
    if (clas == Byte.TYPE)
        return "B";
    if (clas == Short.TYPE)
        return "S";
    if (clas == Integer.TYPE)
        return "I";
    if (clas == Long.TYPE)
        return "J";
    if (clas == Float.TYPE)
        return "F";
    if (clas == Double.TYPE)
        return "D";
    if (clas == Void.TYPE)
        return "V";
    // Is getName() ok?  test with 1.1
    String name = clas.getName().replace('.', '/');
    if (name.startsWith("[") || name.endsWith(";"))
        return name;
    else
        return "L" + name.replace('.', '/') + ";";
}