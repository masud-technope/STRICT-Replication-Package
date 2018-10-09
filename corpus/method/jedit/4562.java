//}}}
//{{{ getSelectedNames() method
/**
	 * Returns the set of user selected encoding names.
	 */
public static Set<String> getSelectedNames() {
    Set<String> set = getAvailableNames();
    Iterator<String> i = set.iterator();
    while (i.hasNext()) {
        String name = i.next();
        if (jEdit.getBooleanProperty("encoding.opt-out." + name, false)) {
            i.remove();
        }
    }
    return set;
}