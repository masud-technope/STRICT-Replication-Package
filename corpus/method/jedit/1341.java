/**
         * Create an enumeration over the given object
         *
         * @param iterateOverMe Object of type Enumeration, Vector, String,
         *                      StringBuffer or an array
         *
         * @return an enumeration
         *
         * @throws java.lang.IllegalArgumentException If the argument is not a
         * supported (i.e. iterable) type.
         *
         * @throws java.lang.NullPointerException If the argument is null
         */
protected Enumeration createEnumeration(Object iterateOverMe) {
    if (iterateOverMe == null)
        throw new NullPointerException("Object arguments passed to " + "the BasicBshIterator constructor cannot be null.");
    if (iterateOverMe instanceof Enumeration)
        return (Enumeration) iterateOverMe;
    if (iterateOverMe instanceof Vector)
        return ((Vector) iterateOverMe).elements();
    if (iterateOverMe.getClass().isArray()) {
        final Object array = iterateOverMe;
        return new Enumeration() {

            int index = 0, length = Array.getLength(array);

            public Object nextElement() {
                return Array.get(array, index++);
            }

            public boolean hasMoreElements() {
                return index < length;
            }
        };
    }
    if (iterateOverMe instanceof String)
        return createEnumeration(((String) iterateOverMe).toCharArray());
    if (iterateOverMe instanceof StringBuffer)
        return createEnumeration(iterateOverMe.toString().toCharArray());
    if (iterateOverMe instanceof StringBuilder)
        return createEnumeration(iterateOverMe.toString().toCharArray());
    throw new IllegalArgumentException("Cannot enumerate object of type " + iterateOverMe.getClass());
}