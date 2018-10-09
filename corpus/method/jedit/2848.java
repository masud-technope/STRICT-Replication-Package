public int compare(Buffer o1, Buffer o2) {
    int ret = StandardUtilities.compareStrings(o1.getName(), o2.getName(), true);
    if (ret == 0) {
        ret = StandardUtilities.compareStrings(o1.getPath(), o2.getPath(), true);
    }
    return ret;
}