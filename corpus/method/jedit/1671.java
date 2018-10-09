/**
        Import a class name.
        Subsequent imports override earlier ones
    */
public void importClass(String name) {
    if (importedClasses == null)
        importedClasses = new Hashtable();
    importedClasses.put(Name.suffix(name, 1), name);
    nameSpaceChanged();
}