/**
        Helper that caches class.
    */
void cacheClass(String name, Class c) {
    if (classCache == null) {
        classCache = new Hashtable();
    //cacheCount++; // debug
    }
    classCache.put(name, c);
}