/**
		Clear global class cache and notify namespaces to clear their 
		class caches.

		The listener list is implemented with weak references so that we 
		will not keep every namespace in existence forever.
	*/
protected void classLoaderChanged() {
    // clear the static caches in BshClassManager
    clearCaches();
    // safely remove
    Vector toRemove = new Vector();
    for (Enumeration e = listeners.elements(); e.hasMoreElements(); ) {
        WeakReference wr = (WeakReference) e.nextElement();
        Listener l = (Listener) wr.get();
        if (// garbage collected
        l == null)
            toRemove.add(wr);
        else
            l.classLoaderChanged();
    }
    for (Enumeration e = toRemove.elements(); e.hasMoreElements(); ) listeners.removeElement(e.nextElement());
}