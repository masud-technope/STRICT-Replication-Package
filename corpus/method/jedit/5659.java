@Override
public int compare(Entry e1, Entry e2) {
    int result;
    switch(type) {
        case COLUMN_INSTALL:
            result = (e1.install == e2.install) ? 0 : (e1.install ? 1 : -1);
            break;
        case COLUMN_NAME:
            result = e1.name.compareToIgnoreCase(e2.name);
            break;
        case COLUMN_CATEGORY:
            result = e1.set.compareToIgnoreCase(e2.set);
            if (result == 0) {
                result = e1.name.compareToIgnoreCase(e2.name);
            }
            break;
        case COLUMN_VERSION:
            result = StandardUtilities.compareStrings(e1.version, e2.version, true);
            break;
        case COLUMN_SIZE:
            result = (e1.size < e2.size) ? -1 : ((e1.size == e2.size) ? 0 : 1);
            break;
        case COLUMN_RELEASE:
            result = (e1.timestamp < e2.timestamp) ? -1 : ((e1.timestamp == e2.timestamp) ? 0 : 1);
            break;
        default:
            result = 0;
    }
    return result * sortDirection;
}