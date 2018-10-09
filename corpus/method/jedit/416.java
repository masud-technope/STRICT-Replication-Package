public void mkdirs(String directory) throws IOException {
    File file = new File(directory);
    if (!file.exists()) {
        String[] mkdirArgs = { "mkdir", "-m", "755", "-p", directory };
        exec(mkdirArgs);
    }
}