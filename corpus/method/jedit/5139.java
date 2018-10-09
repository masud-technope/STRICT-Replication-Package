public static String abbreviate(String path) {
    if (svc == null)
        svc = new VarCompressor();
    return svc.compress(path);
}