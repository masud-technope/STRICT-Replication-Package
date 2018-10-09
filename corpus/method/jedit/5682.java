//{{{ setValueAt() method
@Override
public void setValueAt(Object aValue, int row, int column) {
    if (column != 0)
        return;
    Entry entry = filteredEntries.get(row);
    boolean before = entry.install;
    entry.install = Boolean.TRUE.equals(aValue);
    if (before == entry.install)
        return;
    // If the user cancelled, don't proceed
    if (!entry.install && !deselectDependents(entry)) {
        return;
    }
    // checked is set after deselectDependents to prevent
    // override when the user cancelled deselectDependents
    entry.checked = entry.install;
    updateDeps(entry);
    /* prune entries to install to keep only the entries
			 * really checked by the user.
			 * Removes dependencies no longer required and such */
    List<Entry> selected = new ArrayList<Entry>(entries.size());
    for (Entry temp : entries) {
        if (temp.install)
            selected.add(temp);
    }
    List<Entry> toRemove = new ArrayList<Entry>(selected.size());
    boolean changed;
    do {
        changed = false;
        for (Entry temp : selected) {
            temp.dependents.removeAll(toRemove);
            if (!temp.checked && temp.dependents.isEmpty()) {
                toRemove.add(temp);
                temp.install = false;
                changed = true;
            }
        }
        selected.removeAll(toRemove);
    } while (changed);
    updateFilteredEntries();
    // make the row selected after updated filtering
    for (int i = 0; i < filteredEntries.size(); i++) {
        if (entry == filteredEntries.get(i)) {
            table.setRowSelectionInterval(i, i);
            break;
        }
    }
//}}}
}