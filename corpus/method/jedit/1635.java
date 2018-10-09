private String[] enumerationToStringArray(Enumeration e) {
    Vector v = new Vector();
    while (e.hasMoreElements()) v.addElement(e.nextElement());
    String[] sa = new String[v.size()];
    v.copyInto(sa);
    return sa;
}