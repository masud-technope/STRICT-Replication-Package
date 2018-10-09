public static void setPermissions(String path, int permissions) {
    if (jEdit.getBooleanProperty("chmodDisabled"))
        return;
    if (permissions != 0) {
        if (OperatingSystem.isUnix()) {
            String[] cmdarray = { "chmod", Integer.toString(permissions, 8), path };
            try {
                Process process = Runtime.getRuntime().exec(cmdarray);
                process.getInputStream().close();
                process.getOutputStream().close();
                process.getErrorStream().close();
            } catch (Throwable t) {
            }
        }
    }
}