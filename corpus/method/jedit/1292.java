/**
		Clear everything and reset the path to empty.
	*/
private synchronized void reset() {
    path = new ArrayList();
    compPaths = null;
    clearCachedStructures();
}