private static boolean isPublic(Constructor c) {
    return Modifier.isPublic(c.getModifiers());
}