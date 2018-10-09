public void mkdirs(String directory) throws IOException {
    File file = new File(directory);
    if (!file.exists())
        file.mkdirs();
}