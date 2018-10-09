/**
		Fire the NameSourceListeners
	*/
void nameSpaceChanged() {
    if (nameSourceListeners == null)
        return;
    for (int i = 0; i < nameSourceListeners.size(); i++) ((NameSource.Listener) (nameSourceListeners.get(i))).nameSourceChanged(this);
}