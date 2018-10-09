/**
    */
public void importStatic(Class clas) {
    if (importedStatic == null)
        importedStatic = new Vector();
    // If it exists, remove it and add it at the end (avoid memory leak)
    if (importedStatic.contains(clas))
        importedStatic.remove(clas);
    importedStatic.addElement(clas);
    nameSpaceChanged();
}