/**
        This method is a temporary workaround used with definingClass.
        It is to be removed at some point.
    */
protected String getClassBeingDefined(String className) {
    String baseName = Name.suffix(className, 1);
    return (String) definingClassesBaseNames.get(baseName);
}