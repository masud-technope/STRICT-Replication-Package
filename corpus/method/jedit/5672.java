//{{{ updateFilteredEntries() method
void updateFilteredEntries() {
    filteredEntries.clear();
    if (filterString == null) {
        if (!hideInstalled) {
            filteredEntries.addAll(entries);
        } else {
            for (Entry e : entries) {
                if (e.install || e.installedVersion == null || updates) {
                    filteredEntries.add(e);
                }
            }
        }
    } else {
        String[] words = filterString.toLowerCase().split("\\s+");
        for (Entry e : entries) {
            if (e.install) {
                filteredEntries.add(e);
                continue;
            }
            if (hideInstalled && e.installedVersion != null) {
                continue;
            }
            String s = (e.name + ' ' + e.set + ' ' + e.description).toLowerCase();
            boolean hasAll = true;
            boolean negative = false;
            for (String word : words) {
                if (word.startsWith("-")) {
                    word = word.substring(1);
                    negative = true;
                }
                if (word.length() == 0)
                    continue;
                if (negative == s.contains(word)) {
                    hasAll = false;
                    break;
                }
                negative = false;
            }
            if (hasAll)
                filteredEntries.add(e);
        }
    }
    fireTableChanged(new TableModelEvent(PluginTableModel.this));
//}}}
}