public BshIterator getBshIterator(Object obj) throws IllegalArgumentException {
    if (obj instanceof Collection || obj instanceof Iterator)
        return new CollectionIterator(obj);
    else
        return new org.gjt.sp.jedit.bsh.CollectionManager.BasicBshIterator(obj);
}