/**
        Annotate the NoClassDefFoundError with some info about the class
        we were trying to load.
    */
protected static Error noClassDefFound(String className, Error e) {
    return new NoClassDefFoundError("A class required by class: " + className + " could not be loaded:\n" + e.toString());
}