//}}}
//{{{ updateStructureHighlight() method
private void updateStructureHighlight() {
    if (!painter.isStructureHighlightEnabled() && !gutter.isStructureHighlightEnabled())
        return;
    for (StructureMatcher matcher : structureMatchers) {
        match = matcher.getMatch(this);
        if (match != null)
            break;
    }
    if (match != null) {
        if (caretLine < match.startLine)
            invalidateLineRange(caretLine, match.endLine);
        else
            invalidateLineRange(match.startLine, caretLine);
        if (!displayManager.isLineVisible(match.startLine) || chunkCache.getScreenLineOfOffset(match.startLine, match.start - getLineStartOffset(match.startLine)) == -1) {
            showStructureStatusMessage(match.startLine < caretLine);
        }
    }
}