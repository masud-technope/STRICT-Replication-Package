@Override
public int compare(MenuItem obj1, MenuItem obj2) {
    return StandardUtilities.compareStrings(obj1.label, obj2.label, false);
}