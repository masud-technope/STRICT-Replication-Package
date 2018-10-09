public void perform(String installDir, Vector filesets) {
    if (!enabled || !filesets.contains("jedit-windows"))
        return;
    File executable = new File(installDir, "jedit.exe");
    if (!executable.exists())
        return;
    String[] args = { executable.getPath(), "/i", System.getProperty("java.home") + File.separator + "bin" };
    try {
        Runtime.getRuntime().exec(args).waitFor();
    } catch (IOException io) {
    } catch (InterruptedException ie) {
    }
}