//}}}
//{{{ trimToLimit() method
private static void trimToLimit(Deque<Entry> list) {
    int max = jEdit.getIntegerProperty("recentFiles", 40);
    while (list.size() > max) list.removeLast();
}