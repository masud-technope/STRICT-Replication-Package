/**
     * Add a new fileset
     * 
     * @return the fileset to be used as the nested element.
     */
public FileSet createFileSet() {
    FileSet fileSet = new FileSet();
    fileSets.addElement(fileSet);
    return fileSet;
}