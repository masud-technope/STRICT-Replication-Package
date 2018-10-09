public static String methodString(String name, Class[] types) {
    StringBuilder sb = new StringBuilder(name + "(");
    if (types.length > 0)
        sb.append(" ");
    for (int i = 0; i < types.length; i++) {
        Class c = types[i];
        sb.append(((c == null) ? "null" : c.getName()) + (i < (types.length - 1) ? ", " : " "));
    }
    sb.append(")");
    return sb.toString();
}