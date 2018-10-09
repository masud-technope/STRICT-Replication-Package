@Override
public boolean loadLayout(String baseName, int viewIndex) {
    String filename = getLayoutFilename(baseName, viewIndex);
    DefaultHandler handler = getPerspectiveHandler();
    try {
        // no need to close the stream it is closed by XMLUtilities.parseXML() method
        XMLUtilities.parseXML(new FileInputStream(filename), handler);
    } catch (FileNotFoundException e) {
        return false;
    } catch (IOException e) {
        return false;
    }
    return true;
}