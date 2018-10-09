public int compare(Abbrev a1, Abbrev a2) {
    if (col == 0) {
        String abbrev1 = a1.abbrev.toLowerCase();
        String abbrev2 = a2.abbrev.toLowerCase();
        return StandardUtilities.compareStrings(abbrev1, abbrev2, true);
    } else {
        String expand1 = a1.expand.toLowerCase();
        String expand2 = a2.expand.toLowerCase();
        return StandardUtilities.compareStrings(expand1, expand2, true);
    }
}