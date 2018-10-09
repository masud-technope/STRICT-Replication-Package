public int compare(Buffer o1, Buffer o2) {
    return StandardUtilities.compareStrings(o1.getPath(), o2.getPath(), true);
}