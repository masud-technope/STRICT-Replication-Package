Entry[] getTransitiveDependents() {
    List<Entry> list = new ArrayList<Entry>();
    getTransitiveDependents(list);
    Entry[] array = list.toArray(new Entry[list.size()]);
    Arrays.sort(array, new StandardUtilities.StringCompare<Entry>(true));
    return array;
}