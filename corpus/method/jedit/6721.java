//{{{ init() method
void init() {
    // DisplayManager is active in it.
    assert textArea.getDisplayManager() == this;
    if (buffer.isLoading())
        // init() will be called later from bufferLoaded().
        return;
    if (!initialized) {
        folds.reset(buffer.getLineCount());
        resetAnchors();
        int collapseFolds = buffer.getIntegerProperty("collapseFolds", 0);
        if (collapseFolds != 0)
            expandFolds(collapseFolds);
        initialized = true;
    } else {
        // Already initialized.
        // Just make the scroll bar updated.
        resetAnchors();
    }
}