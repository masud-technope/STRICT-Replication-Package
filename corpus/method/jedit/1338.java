/**
         * Construct a basic BasicBshIterator
         *
         * @param iterateOverMe The object over which we are iterating
         *
         * @throws java.lang.IllegalArgumentException If the argument is not a
         * supported (i.e. iterable) type.
         *
         * @throws java.lang.NullPointerException If the argument is null
         */
public  BasicBshIterator(Object iterateOverMe) {
    enumeration = createEnumeration(iterateOverMe);
}