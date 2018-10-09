//}}}
//{{{ addToolBar() method
private static void addToolBar(Container group, List<Entry> toolbars, Entry entry) {
    // See if we should place this toolbar before any others
    for (int i = 0; i < toolbars.size(); i++) {
        if (entry.layer > toolbars.get(i).layer) {
            toolbars.add(i, entry);
            group.add(entry.toolbar, i);
            return;
        }
    }
    // Place the toolbar at the bottom of the group
    toolbars.add(entry);
    group.add(entry.toolbar);
}