public static boolean canGenerateInterfaces() {
    // classExists caches info for us
    return classExists("java.lang.reflect.Proxy");
}