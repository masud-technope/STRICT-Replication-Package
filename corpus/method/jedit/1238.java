public static byte[] readBytesFromFile(File base, String className) {
    String n = className.replace('.', File.separatorChar) + ".class";
    File file = new File(base, n);
    if (file == null || !file.exists())
        return null;
    byte[] bytes;
    try {
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        bytes = new byte[(int) file.length()];
        dis.readFully(bytes);
        dis.close();
    } catch (IOException ie) {
        throw new RuntimeException("Couldn't load file: " + file);
    }
    return bytes;
}