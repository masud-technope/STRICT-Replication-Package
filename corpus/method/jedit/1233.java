/**
		Implements NameSource
		Add a listener who is notified upon changes to names in this space.
	*/
public void addNameSourceListener(NameSource.Listener listener) {
    if (nameSourceListeners == null)
        nameSourceListeners = new ArrayList();
    nameSourceListeners.add(listener);
}