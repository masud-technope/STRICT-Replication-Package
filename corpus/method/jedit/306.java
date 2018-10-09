/**
     * Add a new fileset for the control files with the option to specify permissions
     * 
     * @return the tar fileset to be used as the nested element.
     */
public TarFileSet createControlFileSet() {
    TarFileSet fileSet = controlTarGz.createTarFileSet();
    controlFileSets.addElement(fileSet);
    return fileSet;
}