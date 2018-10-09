// {{{ Compare Method.
public int compare(JMenuItem obj1, JMenuItem obj2) {
    int compareValue = 0;
    boolean obj1E = obj1 instanceof EnhancedMenuItem;
    boolean obj2E = obj2 instanceof EnhancedMenuItem;
    if (obj1E && !obj2E) {
        compareValue = 1;
    } else if (obj2E && !obj1E) {
        compareValue = -1;
    } else {
        compareValue = StandardUtilities.compareStrings(obj1.getText(), obj2.getText(), true);
    }
    return compareValue;
}