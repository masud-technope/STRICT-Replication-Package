protected boolean isClassBeingDefined(String className) {
    return definingClasses.get(className) != null;
}