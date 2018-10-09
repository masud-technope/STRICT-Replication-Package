public static boolean isArchiveFileName(String name) {
    name = name.toLowerCase();
    return (name.endsWith(".jar") || name.endsWith(".zip"));
}