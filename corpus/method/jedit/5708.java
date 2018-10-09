@Override
public int compare(Entry e1, Entry e2) {
    int result;
    switch(type) {
        case NAME:
            result = compareNames(e1, e2);
            break;
        case VERSION:
            result = StandardUtilities.compareStrings(e1.version, e2.version, true);
            break;
        case STATUS:
            result = e1.status.compareToIgnoreCase(e2.status);
            break;
        case DATA:
            result = StandardUtilities.compareStrings(e1.dataSize, e2.dataSize, false);
            break;
        default:
            throw new IllegalStateException("Invalid sort type " + type);
    }
    return result * direction;
}