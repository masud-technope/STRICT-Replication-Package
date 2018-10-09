/**
        Clear the caches in BshClassManager
    */
protected void clearCaches() {
    absoluteNonClasses = new Hashtable();
    absoluteClassCache = new Hashtable();
    resolvedObjectMethods = new Hashtable();
    resolvedStaticMethods = new Hashtable();
}