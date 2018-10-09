/**
     * Add a new fileset with the option to specify permissions
     * @return the ar fileset to be used as the nested element.
     */
public ArFileSet createArFileSet() {
    ArFileSet fileset = new ArFileSet();
    filesets.addElement(fileset);
    return fileset;
}