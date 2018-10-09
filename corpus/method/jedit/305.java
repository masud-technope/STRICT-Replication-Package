/**
     * Add a new fileset for the data files with the option to specify permissions
     * 
     * @return the tar fileset to be used as the nested element.
     */
public TarFileSet createDataFileSet() {
    TarFileSet fileSet = dataTarGz.createTarFileSet();
    dataFileSets.addElement(fileSet);
    return fileSet;
}