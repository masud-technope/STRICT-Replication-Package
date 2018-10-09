//}}}
//{{{ bufferLoaded() method
void bufferLoaded() {
    initialized = false;
    folds.reset(buffer.getLineCount());
    screenLineMgr.reset();
    if (textArea.getDisplayManager() == this) {
        textArea.propertiesChanged();
        init();
    } else {
    // init() will be called later when the buffer
    // is set in the textArea.
    }
}