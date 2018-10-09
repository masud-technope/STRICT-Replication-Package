//}}}
//{{{ updateScreenLineCount() method
void updateScreenLineCount(int line) {
    // instead of textArea.
    assert textArea.getDisplayManager() == this;
    if (!screenLineMgr.isScreenLineCountValid(line)) {
        // reset chunk cache here
        textArea.chunkCache.reset();
        int newCount = textArea.chunkCache.getLineSubregionCount(line);
        assert newCount > 0;
        setScreenLineCount(line, newCount);
    }
}