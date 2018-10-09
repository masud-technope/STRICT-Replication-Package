public static String[] bubbleSort(String[] in) {
    Vector v = new Vector();
    for (String element : in) v.addElement(element);
    int n = v.size();
    boolean swap = true;
    while (swap) {
        swap = false;
        for (int i = 0; i < (n - 1); i++) if (((String) v.elementAt(i)).compareTo(((String) v.elementAt(i + 1))) > 0) {
            String tmp = (String) v.elementAt(i + 1);
            v.removeElementAt(i + 1);
            v.insertElementAt(tmp, i);
            swap = true;
        }
    }
    String[] out = new String[n];
    v.copyInto(out);
    return out;
}