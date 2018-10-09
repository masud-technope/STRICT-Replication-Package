public static boolean recursiveDelete(File path) {
    if (path.exists()) {
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                recursiveDelete(file);
            else
                file.delete();
        }
    }
    return path.delete();
}