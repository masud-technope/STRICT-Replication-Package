//}}}
//{{{ getAllPluginEntries() method
/**
	 * If remove is false, only remove from clones list, otherwise remove
	 * from both entries and clones.
	 */
private Iterator<Entry> getAllPluginEntries(PluginJAR plugin, boolean remove) {
    List<Entry> returnValue = new LinkedList<Entry>();
    Iterator<Entry> iter = windows.values().iterator();
    while (iter.hasNext()) {
        Entry entry = iter.next();
        if (entry.factory.plugin == plugin) {
            returnValue.add(entry);
            if (remove)
                iter.remove();
        }
    }
    iter = clones.iterator();
    while (iter.hasNext()) {
        Entry entry = iter.next();
        if (entry.factory.plugin == plugin) {
            returnValue.add(entry);
            iter.remove();
        }
    }
    return returnValue.iterator();
}