//}}}
//{{{ removeToolBar() method
private static void removeToolBar(Container group, List<Entry> toolbars, Component toolbar) {
    for (int i = 0; i < toolbars.size(); i++) {
        if (toolbar == toolbars.get(i).toolbar) {
            group.remove(toolbar);
            toolbars.remove(i);
            return;
        }
    }
}