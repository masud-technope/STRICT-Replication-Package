public int compare(Object obj1, Object obj2) {
    Entry e1 = (Entry) obj1;
    Entry e2 = (Entry) obj2;
    return StandardUtilities.compareStrings(e1.title, e2.title, true);
}