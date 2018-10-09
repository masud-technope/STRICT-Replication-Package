/*
        For serialization.
        Don't serialize non-serializable objects.
    */
private synchronized void writeObject(java.io.ObjectOutputStream s) throws IOException {
    // clear name resolvers... don't know if this is necessary.
    names = null;
    s.defaultWriteObject();
}