//}}}
//{{{ addEntry() method
private void addEntry(DockableWindowFactory.Window factory) {
    Entry e;
    if (view.isPlainView()) {
        // don't show menu items to dock into a plain view
        e = new Entry(factory, FLOATING);
    } else {
        e = new Entry(factory);
        if (e.position.equals(FLOATING))
            /* nothing to do */
            ;
        else if (e.position.equals(TOP))
            e.container = top;
        else if (e.position.equals(LEFT))
            e.container = left;
        else if (e.position.equals(BOTTOM))
            e.container = bottom;
        else if (e.position.equals(RIGHT))
            e.container = right;
        else {
            Log.log(Log.WARNING, this, "Unknown position: " + e.position);
        }
        if (e.container != null)
            e.container.register(e);
    }
    windows.put(factory.name, e);
}