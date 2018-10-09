public static String getProtocolOfURL(String url) {
    return url.substring(0, url.indexOf(':'));
}