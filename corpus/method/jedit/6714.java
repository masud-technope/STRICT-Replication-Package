//}}}
//{{{ foldHandlerChanged() method
void foldHandlerChanged() {
    if (buffer.isLoading())
        // bufferLoaded().
        return;
    initialized = false;
    folds.reset(buffer.getLineCount());
    if (textArea.getDisplayManager() == this) {
        init();
    } else {
    // init() will be called later when the buffer
    // is set in the textArea.
    }
}