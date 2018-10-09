// {{{ loadPrintSpec() method
// this finds a previously saved print attribute set in the settings directory,
// or creates a new, empty attribute set if not found.
private static void loadPrintSpec() {
    format = new HashPrintRequestAttributeSet();
    String settings = jEdit.getSettingsDirectory();
    if (settings != null) {
        String printSpecPath = MiscUtilities.constructPath(settings, "printspec");
        File filePrintSpec = new File(printSpecPath);
        if (filePrintSpec.exists()) {
            FileInputStream fileIn;
            ObjectInputStream obIn = null;
            try {
                fileIn = new FileInputStream(filePrintSpec);
                obIn = new ObjectInputStream(fileIn);
                format = (HashPrintRequestAttributeSet) obIn.readObject();
            } catch (Exception e) {
                Log.log(Log.ERROR, BufferPrinter1_7.class, e);
            } finally {
                try {
                    if (obIn != null) {
                        obIn.close();
                    }
                } catch (IOException // NOPMD
                e) {
                }
            }
        }
    }
    MediaPrintableArea mpa = (MediaPrintableArea) format.get(MediaPrintableArea.class);
    if (mpa == null) {
        // assume US Letter size - why? Because I live in the US
        mpa = new MediaPrintableArea(0.5f, 0.5f, 10.0f, 7.5f, MediaPrintableArea.INCH);
        format.add(mpa);
    }
    format.remove(Reverse.class);
}