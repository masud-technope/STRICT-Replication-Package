@Override
public int compare(KeyBinding[] k1, KeyBinding[] k2) {
    String label1 = k1[0].label.toLowerCase();
    String label2 = k2[0].label.toLowerCase();
    if (col == 0)
        return StandardUtilities.compareStrings(label1, label2, true);
    else {
        String shortcut1, shortcut2;
        if (col == 1) {
            shortcut1 = k1[0].shortcut;
            shortcut2 = k2[0].shortcut;
        } else {
            shortcut1 = k1[1].shortcut;
            shortcut2 = k2[1].shortcut;
        }
        if (shortcut1 == null && shortcut2 != null)
            return 1;
        else if (shortcut2 == null && shortcut1 != null)
            return -1;
        else if (shortcut1 == null)
            return StandardUtilities.compareStrings(label1, label2, true);
        else
            return StandardUtilities.compareStrings(shortcut1, shortcut2, true);
    }
}