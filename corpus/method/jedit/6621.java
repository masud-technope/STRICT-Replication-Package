//}}}
//{{{ doDelayedUpdate() method
private void doDelayedUpdate() {
    // must be done before the below call
    // so that the chunk cache is not
    // updated with an invisible first
    // line (see above)
    displayManager.notifyScreenLineChanges();
    if (delayedMultilineUpdate) {
        textArea.invalidateScreenLineRange(textArea.chunkCache.getScreenLineOfOffset(delayedUpdateStart, 0), textArea.getVisibleLines());
        delayedMultilineUpdate = false;
    } else {
        textArea.invalidateLineRange(delayedUpdateStart, delayedUpdateEnd);
    }
    // update visible lines
    int visibleLines = textArea.getVisibleLines();
    if (visibleLines != 0) {
        textArea.chunkCache.getLineInfo(visibleLines - 1);
    }
    // force the fold levels to be
    // updated.
    // when painting the last line of
    // a buffer, Buffer.isFoldStart()
    // doesn't call getFoldLevel(),
    // hence the foldLevelChanged()
    // event might not be sent for the
    // previous line.
    buffer.getFoldLevel(delayedUpdateEnd);
}