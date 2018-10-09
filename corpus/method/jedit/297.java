/**
     * do the business
     * 
     * @throws BuildException on error
     */
public void execute() throws BuildException {
    if ((null == realSizeProperty) && (null == diskSizeProperty)) {
        throw new BuildException("realSizeProperty or diskSizeProperty must be set for <CalculateSize>");
    }
    if (null != baseDir) {
        // add the main fileset to the list of filesets to process.
        fileSets.addElement(fileset);
    }
    long realSize = 0;
    long diskSize = 0;
    for (Enumeration e = fileSets.elements(); e.hasMoreElements(); ) {
        FileSet fileSet = (FileSet) e.nextElement();
        String[] files = fileSet.getDirectoryScanner(getProject()).getIncludedFiles();
        File fileSetDir = fileSet.getDir(getProject());
        for (int i = 0, c = files.length; i < c; i++) {
            long fileLength = new File(fileSetDir, files[i]).length();
            realSize += fileLength / 1024;
            diskSize += (fileLength / 4096 + 1) * 4;
        }
    }
    if (null != realSizeProperty) {
        getProject().setNewProperty(realSizeProperty, Long.toString(realSize));
    }
    if (null != diskSizeProperty) {
        getProject().setNewProperty(diskSizeProperty, Long.toString(diskSize));
    }
}