private static boolean isStatic(Method m) {
    return Modifier.isStatic(m.getModifiers());
}