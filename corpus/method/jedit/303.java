/**
     * This is the base directory to look in for things to include in the data files.
     * 
     * @param baseDir the base directory.
     */
public void setBaseDir(File baseDir) {
    this.baseDir = baseDir;
    fileset.setDir(baseDir);
}