//}}}
//{{{ savePrintSpec() method
private static void savePrintSpec() {
    String settings = jEdit.getSettingsDirectory();
    if (settings == null)
        return;
    String printSpecPath = MiscUtilities.constructPath(settings, "printspec");
    File filePrintSpec = new File(printSpecPath);
    FileOutputStream fileOut;
    ObjectOutputStream obOut = null;
    try {
        fileOut = new FileOutputStream(filePrintSpec);
        obOut = new ObjectOutputStream(fileOut);
        obOut.writeObject(format);
        //for backwards compatibility, the color variable is stored also as a property
        Chromaticity cc = (Chromaticity) format.get(Chromaticity.class);
        if (cc != null)
            jEdit.setBooleanProperty("print.color", cc.getValue() == Chromaticity.COLOR.getValue());
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (obOut != null)
            try {
                obOut.close();
            } catch (IOException e) {
            }
    }
}