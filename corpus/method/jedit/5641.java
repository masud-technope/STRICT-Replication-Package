private void getTransitiveDependents(List<Entry> list) {
    for (Entry entry : dependents) {
        if (entry.install && !list.contains(entry)) {
            list.add(entry);
            entry.getTransitiveDependents(list);
        }
    }
}