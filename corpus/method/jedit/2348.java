public static String[] split(String s, String delim) {
    Vector v = new Vector();
    StringTokenizer st = new StringTokenizer(s, delim);
    while (st.hasMoreTokens()) v.addElement(st.nextToken());
    String[] sa = new String[v.size()];
    v.copyInto(sa);
    return sa;
}