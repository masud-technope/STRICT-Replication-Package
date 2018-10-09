private static String win2unix(String winPath) {
    String unixPath = winPath.replace('\\', '/');
    Matcher m = winPattern.matcher(unixPath);
    if (m.find()) {
        String varName = m.group(2);
        String expansion = System.getenv(varName);
        if (expansion != null)
            return m.replaceFirst(expansion);
    }
    return unixPath;
}