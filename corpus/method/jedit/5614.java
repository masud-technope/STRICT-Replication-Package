//}}}
private static boolean continueLoading(String clazz, Properties cachedProperties) {
    if (jEdit.getPlugin(clazz) != null) {
        String otherVersion = jEdit.getProperty("plugin." + clazz + ".version");
        String thisVersion = cachedProperties.getProperty("plugin." + clazz + ".version");
        if (otherVersion.compareTo(thisVersion) > 0)
            return false;
    }
    return true;
}