/**
        This is the factory for Name objects which resolve names within
        this namespace (e.g. toObject(), toClass(), toLHS()).
        <p>

        This was intended to support name resolver caching, allowing
        Name objects to cache info about the resolution of names for
        performance reasons.  However this not proven useful yet.
        <p>

        We'll leave the caching as it will at least minimize Name object
        creation.
        <p>

        (This method would be called getName() if it weren't already used for
        the simple name of the NameSpace)
        <p>

        This method was public for a time, which was a mistake.
        Use get() instead.
    */
Name getNameResolver(String ambigname) {
    if (names == null)
        names = new Hashtable();
    Name name = (Name) names.get(ambigname);
    if (name == null) {
        name = new Name(this, ambigname);
        names.put(ambigname, name);
    }
    return name;
}