//}}}
//{{{ updateChunksUpTo() method
private void updateChunksUpTo(int lastScreenLine) {
    // this method is a nightmare
    if (lastScreenLine >= lineInfo.length)
        throw new ArrayIndexOutOfBoundsException(lastScreenLine);
    // screen line we don't need to update the chunks, leave here
    if (lastScreenLine < firstInvalidLine)
        return;
    int firstScreenLine = getFirstScreenLine();
    int physicalLine = getUpdateStartLine(firstScreenLine);
    if (Debug.CHUNK_CACHE_DEBUG) {
        Log.log(Log.DEBUG, this, "Updating chunks from " + firstScreenLine + " to " + lastScreenLine);
    }
    // Below comment is not true any more (at least partly):
    // Note that we rely on the fact that when a physical line is
    // invalidated, all screen lines/subregions of that line are
    // invalidated as well. See below comment for code that tries
    // to uphold this assumption.
    List<Chunk> out = new ArrayList<Chunk>(0);
    int offset;
    int length;
    for (int i = firstScreenLine; i <= lastScreenLine; i++) {
        LineInfo info = lineInfo[i];
        Chunk chunks;
        // get another line of chunks
        if (out.isEmpty()) {
            // the line number
            if (physicalLine != -1 && i != firstScreenLine) {
                physicalLine = textArea.displayManager.getNextVisibleLine(physicalLine);
            }
            // empty space
            if (physicalLine == -1) {
                info.chunks = null;
                info.physicalLine = -1;
                // fix the bug where the horiz.
                // scroll bar was not updated
                // after creating a new file.
                info.width = 0;
                continue;
            }
            // chunk the line.
            lineToChunkList(physicalLine);
            out = outFull.subList(0, outFull.size());
            info.firstSubregion = true;
            // if the line has no text, out.size() == 0
            if (out.isEmpty()) {
                if (i == 0) {
                    if (textArea.displayManager.firstLine.getSkew() > 0) {
                        Log.log(Log.ERROR, this, "BUG: skew=" + textArea.displayManager.firstLine.getSkew() + ",out.size()=" + out.size());
                        textArea.displayManager.firstLine.setSkew(0);
                        needFullRepaint = true;
                        lastScreenLine = lineInfo.length - 1;
                    }
                }
                chunks = null;
                offset = 0;
                length = 1;
            } else // otherwise, the number of subregions
            {
                //FIXME: (i == 0)!? - not (i == firstLine)?
                if (i == 0) {
                    int skew = textArea.displayManager.firstLine.getSkew();
                    if (skew >= out.size()) {
                        // The skew cannot be greater than the chunk count of the line
                        // we need at least one chunk per subregion in a line 
                        Log.log(Log.ERROR, this, "BUG: skew=" + skew + ",out.size()=" + out.size());
                        needFullRepaint = true;
                        lastScreenLine = lineInfo.length - 1;
                    } else if (skew > 0) {
                        info.firstSubregion = false;
                        out = outFull.subList(skew, outFull.size());
                    }
                }
                chunks = out.get(0);
                out = out.subList(1, out.size());
                offset = chunks.offset;
                if (!out.isEmpty())
                    length = out.get(0).offset - offset;
                else
                    length = textArea.getLineLength(physicalLine) - offset + 1;
            }
        } else {
            info.firstSubregion = false;
            chunks = out.get(0);
            out = out.subList(1, out.size());
            offset = chunks.offset;
            if (!out.isEmpty())
                length = out.get(0).offset - offset;
            else
                length = textArea.getLineLength(physicalLine) - offset + 1;
        }
        boolean lastSubregion = out.isEmpty();
        if (i == lastScreenLine && lastScreenLine != lineInfo.length - 1) {
            /* if the user changes the syntax token at the
				 * end of a line, need to do a full repaint. */
            if (tokenHandler.getLineContext() != info.lineContext) {
                lastScreenLine++;
                needFullRepaint = true;
            } else /* If this line has become longer or shorter
				 * (in which case the new physical line number
				 * is different from the cached one) we need to:
				 * - continue updating past the last line
				 * - advise the text area to repaint
				 * On the other hand, if the line wraps beyond
				 * lastScreenLine, we need to keep updating the
				 * chunk list to ensure proper alignment of
				 * invalidation flags (see start of method) */
            if (info.physicalLine != physicalLine || info.lastSubregion != lastSubregion) {
                lastScreenLine++;
                needFullRepaint = true;
            } else /* We only cache entire physical lines at once;
				 * don't want to split a physical line into
				 * screen lines and only have some valid. */
            if (!out.isEmpty())
                lastScreenLine++;
        }
        info.physicalLine = physicalLine;
        info.lastSubregion = lastSubregion;
        info.offset = offset;
        info.length = length;
        info.chunks = chunks;
        info.lineContext = tokenHandler.getLineContext();
    }
    firstInvalidLine = Math.max(lastScreenLine + 1, firstInvalidLine);
}