//}}}
//{{{ delayUpdate() method
private void delayUpdate(int startLine, int endLine) {
    textArea.chunkCache.invalidateChunksFromPhys(startLine);
    if (!delayedUpdate) {
        delayedUpdateStart = startLine;
        delayedUpdateEnd = endLine;
        delayedUpdate = true;
    } else {
        delayedUpdateStart = Math.min(delayedUpdateStart, startLine);
        delayedUpdateEnd = Math.max(delayedUpdateEnd, endLine);
    }
}