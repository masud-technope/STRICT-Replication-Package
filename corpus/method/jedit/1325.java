/**
     * Construct a basic CollectionIterator
     *
     * @param iterateOverMe The object over which we are iterating
     *
     * @throws java.lang.IllegalArgumentException If the argument is not a
     * supported (i.e. iterable) type.
     *
     * @throws java.lang.NullPointerException If the argument is null
     */
public  CollectionIterator(Object iterateOverMe) {
    iterator = createIterator(iterateOverMe);
}