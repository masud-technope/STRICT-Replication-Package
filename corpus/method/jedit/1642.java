/**
        Flatten the vectors of overloaded methods to a single array.
        @see #getMethods()
    */
private BshMethod[] flattenMethodCollection(Enumeration e) {
    Vector v = new Vector();
    while (e.hasMoreElements()) {
        Object o = e.nextElement();
        if (o instanceof BshMethod)
            v.addElement(o);
        else {
            Vector ov = (Vector) o;
            for (int i = 0; i < ov.size(); i++) v.addElement(ov.elementAt(i));
        }
    }
    BshMethod[] bma = new BshMethod[v.size()];
    v.copyInto(bma);
    return bma;
}