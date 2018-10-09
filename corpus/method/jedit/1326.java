/**
     * Create an iterator over the given object
     *
     * @param iterateOverMe Object of type Iterator, Collection, or types
     * supported by CollectionManager.BasicBshIterator
     *
     * @return an Iterator
     *
     * @throws java.lang.IllegalArgumentException If the argument is not a
     * supported (i.e. iterable) type.
     *
     * @throws java.lang.NullPointerException If the argument is null
     */
protected Iterator createIterator(Object iterateOverMe) {
    if (iterateOverMe == null)
        throw new NullPointerException("Object arguments passed to " + "the CollectionIterator constructor cannot be null.");
    if (iterateOverMe instanceof Iterator)
        return (Iterator) iterateOverMe;
    if (iterateOverMe instanceof Collection)
        return ((Collection) iterateOverMe).iterator();
    throw new IllegalArgumentException("Cannot enumerate object of type " + iterateOverMe.getClass());
}