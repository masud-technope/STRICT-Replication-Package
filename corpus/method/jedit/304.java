/**
     * Set the name/location of where to create the deb file.
     * 
     * @param destFile The output of the deb
     */
public void setDestFile(File destFile) {
    this.destFile = destFile;
    debPackage.setDestFile(destFile);
}