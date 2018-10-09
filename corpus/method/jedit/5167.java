public void loadIfNecessary() {
    if (marker == null) {
        ModeProvider.instance.loadMode(this);
        if (marker == null)
            Log.log(Log.ERROR, this, "Mode not correctly loaded, token marker is still null");
    }
}