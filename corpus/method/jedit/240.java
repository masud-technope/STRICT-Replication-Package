/**
     * ar a file
     * @param file the file to ar
     * @param aOut the output stream
     * @param arFileSet the fileset that the file came from.
     * @throws IOException on error
     */
protected void arFile(File file, ArOutputStream aOut, ArFileSet arFileSet) throws IOException {
    FileInputStream fIn = null;
    if (file.isDirectory()) {
        return;
    }
    String fileName = file.getName();
    String fullpath = arFileSet.getFullpath();
    if (fullpath.length() > 0) {
        fileName = fullpath.substring(fullpath.lastIndexOf('/'));
    }
    // don't add "" to the archive
    if (fileName.length() <= 0) {
        return;
    }
    try {
        if ((fileName.length() >= ArConstants.NAMELEN) || (-1 != fileName.indexOf(' '))) {
            if (longFileMode.isOmitMode()) {
                log("Omitting: " + fileName, Project.MSG_INFO);
                return;
            } else if (longFileMode.isWarnMode()) {
                if (!longWarningGiven) {
                    log("Resulting ar file contains truncated or space converted filenames", Project.MSG_WARN);
                    longWarningGiven = true;
                }
                log("Entry: \"" + fileName + "\" longer than " + ArConstants.NAMELEN + " characters or containing spaces.", Project.MSG_WARN);
            } else if (longFileMode.isFailMode()) {
                throw new BuildException("Entry: \"" + fileName + "\" longer than " + ArConstants.NAMELEN + "characters or containting spaces.", getLocation());
            }
        }
        ArEntry ae = new ArEntry(fileName);
        ae.setFileDate(file.lastModified());
        ae.setUserId(arFileSet.getUid());
        ae.setGroupId(arFileSet.getGid());
        ae.setMode(arFileSet.getMode());
        ae.setSize(file.length());
        aOut.putNextEntry(ae);
        fIn = new FileInputStream(file);
        byte[] buffer = new byte[8 * 1024];
        int count = 0;
        do {
            aOut.write(buffer, 0, count);
            count = fIn.read(buffer, 0, buffer.length);
        } while (count != -1);
        aOut.closeEntry();
    } finally {
        if (fIn != null) {
            fIn.close();
        }
    }
}