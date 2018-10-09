/**
		Clear anything cached.  All will be reconstructed as necessary.
	*/
private synchronized void clearCachedStructures() {
    mapsInitialized = false;
    packageMap = new HashMap();
    classSource = new HashMap();
    unqNameTable = null;
    nameSpaceChanged();
}