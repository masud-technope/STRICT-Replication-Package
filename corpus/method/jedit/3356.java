//}}}
//{{{ close() method
/**
	 * Called when the view is being closed.
	 * @since jEdit 2.6pre3
	 */
public void close() {
    super.close();
    for (Entry entry : windows.values()) {
        if (entry.win != null)
            entry.container.unregister(entry);
    }
    for (Entry clone : clones) {
        if (clone.win != null)
            clone.container.unregister(clone);
    }
}