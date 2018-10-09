public static boolean getBoolean(Object obj, boolean def) {
    if (obj == null)
        return def;
    else if (obj instanceof Boolean)
        return ((Boolean) obj).booleanValue();
    else if ("true".equals(obj) || "yes".equals(obj) || "on".equals(obj))
        return true;
    else if ("false".equals(obj) || "no".equals(obj) || "off".equals(obj))
        return false;
    return def;
}