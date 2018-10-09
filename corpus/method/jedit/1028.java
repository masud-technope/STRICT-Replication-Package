/**
        Cache info about whether name is a class or not.
        @param value
            if value is non-null, cache the class
            if value is null, set the flag that it is *not* a class to
            speed later resolution
    */
public void cacheClassInfo(String name, Class value) {
    if (value != null)
        absoluteClassCache.put(name, value);
    else
        absoluteNonClasses.put(name, NOVALUE);
}