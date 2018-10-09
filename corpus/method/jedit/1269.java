/**
	*/
void notifyListeners() {
    for (Enumeration e = listeners.elements(); e.hasMoreElements(); ) {
        WeakReference wr = (WeakReference) e.nextElement();
        ClassPathListener l = (ClassPathListener) wr.get();
        if (// garbage collected
        l == null)
            listeners.removeElement(wr);
        else
            l.classPathChanged();
    }
}