public static String constructPath(String parent, String path1, String path2) {
    return constructPath(constructPath(parent, path1), path2);
}