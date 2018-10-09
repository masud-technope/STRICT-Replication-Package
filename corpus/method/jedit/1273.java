public static String[] splitClassname(String classname) {
    classname = canonicalizeClassName(classname);
    int i = classname.lastIndexOf(".");
    String classn, packn;
    if (i == -1) {
        classn = classname;
        packn = "<unpackaged>";
    } else {
        packn = classname.substring(0, i);
        classn = classname.substring(i + 1);
    }
    return new String[] { packn, classn };
}