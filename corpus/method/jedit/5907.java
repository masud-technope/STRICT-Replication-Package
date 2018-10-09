private static void savePrintSpec() {
    String settings = jEdit.getSettingsDirectory();
    if (settings == null) {
        return;
    }
    String printSpecPath = MiscUtilities.constructPath(settings, "printspec");
    File filePrintSpec = new File(printSpecPath);
    FileOutputStream fileOut;
    ObjectOutputStream objectOut = null;
    try {
        fileOut = new FileOutputStream(filePrintSpec);
        objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(format);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (objectOut != null) {
            try {
                objectOut.flush();
            } catch (IOException // NOPMD
            e) {
            }
            try {
                objectOut.close();
            } catch (IOException // NOPMD
            e) {
            }
        }
    }
}