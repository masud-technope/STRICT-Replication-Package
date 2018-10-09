public void exec(String[] args) throws IOException {
    Process proc = Runtime.getRuntime().exec(args);
    proc.getInputStream().close();
    proc.getOutputStream().close();
    proc.getErrorStream().close();
    try {
        proc.waitFor();
    } catch (InterruptedException ie) {
    }
}