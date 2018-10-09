private static String getRTJarPath() {
    String urlString = Class.class.getResource("/java/lang/String.class").toExternalForm();
    if (!urlString.startsWith("jar:file:"))
        return null;
    int i = urlString.indexOf("!");
    if (i == -1)
        return null;
    return urlString.substring("jar:file:".length(), i);
}