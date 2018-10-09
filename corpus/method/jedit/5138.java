public static String abbreviateView(String path) {
    if (!jEdit.getBooleanProperty("view.abbreviatePaths"))
        return path;
    return abbreviate(path);
}