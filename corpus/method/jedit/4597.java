public static int getPermissions(String path) {
    int permissions = 0;
    if (jEdit.getBooleanProperty("chmodDisabled"))
        return permissions;
    if (OperatingSystem.isUnix()) {
        String[] cmdarray = { "ls", "-lLd", path };
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            Process process = Runtime.getRuntime().exec(cmdarray);
            isr = new InputStreamReader(process.getInputStream());
            reader = new BufferedReader(isr);
            String output = reader.readLine();
            if (output != null) {
                String s = output.substring(1, 10);
                permissions = MiscUtilities.parsePermissions(s);
            }
        } catch (Throwable t) {
        } finally {
            IOUtilities.closeQuietly((Closeable) reader);
        }
    }
    return permissions;
}