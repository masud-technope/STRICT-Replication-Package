/**
        Import a compiled Java object's methods and variables into this
        namespace.  When no scripted method / command or variable is found
        locally in this namespace method / fields of the object will be
        checked.  Objects are checked in the order of import with later imports
        taking precedence.
        <p>
    */
/*
        Note: this impor pattern is becoming common... could factor it out into
        an importedObject Vector class.
    */
public void importObject(Object obj) {
    if (importedObjects == null)
        importedObjects = new Vector();
    // If it exists, remove it and add it at the end (avoid memory leak)
    if (importedObjects.contains(obj))
        importedObjects.remove(obj);
    importedObjects.addElement(obj);
    nameSpaceChanged();
}