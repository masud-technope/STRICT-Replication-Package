/**
        Indicate that the specified class name has been defined and may be
        loaded normally.
    */
protected void doneDefiningClass(String className) {
    String baseName = Name.suffix(className, 1);
    definingClasses.remove(className);
    definingClassesBaseNames.remove(baseName);
}