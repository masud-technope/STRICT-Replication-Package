private static int compareNames(Entry e1, Entry e2) {
    String s1;
    if (e1.name == null)
        s1 = MiscUtilities.getFileName(e1.jar);
    else
        s1 = e1.name;
    String s2;
    if (e2.name == null)
        s2 = MiscUtilities.getFileName(e2.jar);
    else
        s2 = e2.name;
    return s1.compareToIgnoreCase(s2);
}