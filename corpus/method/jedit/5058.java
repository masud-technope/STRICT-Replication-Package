//{{{ finalize() method
// TODO: 'finalize' is deprecated as of Java 9
@SuppressWarnings("deprecation")
protected void finalize() throws Exception {
    if (ebStub != null)
        EditBus.removeFromBus(ebStub);
}