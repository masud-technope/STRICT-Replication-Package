//}}}
//{{{ paintLine() method
private void paintLine(Graphics2D gfx, int line, int y) {
    JEditBuffer buffer = textArea.getBuffer();
    if (buffer.isLoading())
        return;
    FontMetrics textAreaFm = textArea.getPainter().getFontMetrics();
    int lineHeight = textArea.getPainter().getLineHeight();
    int baseline = textAreaFm.getAscent() + textAreaFm.getLeading();
    ChunkCache.LineInfo info = textArea.chunkCache.getLineInfo(line);
    int physicalLine = info.physicalLine;
    // Skip lines beyond EOF
    if (physicalLine == -1)
        return;
    boolean drawFoldMiddle = true;
    //{{{ Paint fold start and end indicators
    if (info.firstSubregion && buffer.isFoldStart(physicalLine)) {
        drawFoldMiddle = false;
        foldPainter.paintFoldStart(this, gfx, line, physicalLine, textArea.displayManager.isLineVisible(physicalLine + 1), y - textArea.getPainter().getLineExtraSpacing(), lineHeight, buffer);
    } else if (info.lastSubregion && buffer.isFoldEnd(physicalLine)) {
        drawFoldMiddle = false;
        foldPainter.paintFoldEnd(this, gfx, line, physicalLine, y - textArea.getPainter().getLineExtraSpacing(), lineHeight, buffer);
    //}}}
    } else //{{{ Paint bracket scope
    if (structureHighlight) {
        StructureMatcher.Match match = textArea.getStructureMatch();
        int caretLine = textArea.getCaretLine();
        if (textArea.isStructureHighlightVisible() && physicalLine >= Math.min(caretLine, match.startLine) && physicalLine <= Math.max(caretLine, match.startLine)) {
            int caretScreenLine;
            if (caretLine > textArea.getLastPhysicalLine())
                caretScreenLine = Integer.MAX_VALUE;
            else if (textArea.displayManager.isLineVisible(textArea.getCaretLine())) {
                caretScreenLine = textArea.getScreenLineOfOffset(textArea.getCaretPosition());
            } else {
                caretScreenLine = -1;
            }
            int structScreenLine;
            if (match.startLine > textArea.getLastPhysicalLine())
                structScreenLine = Integer.MAX_VALUE;
            else if (textArea.displayManager.isLineVisible(match.startLine)) {
                structScreenLine = textArea.getScreenLineOfOffset(match.start);
            } else {
                structScreenLine = -1;
            }
            if (caretScreenLine > structScreenLine) {
                int tmp = caretScreenLine;
                caretScreenLine = structScreenLine;
                structScreenLine = tmp;
            }
            gfx.setColor(structureHighlightColor);
            drawFoldMiddle = false;
            if (structScreenLine == caretScreenLine) {
                // do nothing
                drawFoldMiddle = true;
            } else // draw |^
            if (line == caretScreenLine) {
                gfx.fillRect(5, y + lineHeight / 2, 5, 2);
                gfx.fillRect(5, y + lineHeight / 2, 2, lineHeight - lineHeight / 2);
            } else // draw |_
            if (line == structScreenLine) {
                gfx.fillRect(5, y, 2, lineHeight / 2);
                gfx.fillRect(5, y + lineHeight / 2, 5, 2);
            } else // draw |
            if (line > caretScreenLine && line < structScreenLine) {
                gfx.fillRect(5, y, 2, lineHeight);
            }
        }
    //}}}
    }
    if (drawFoldMiddle && buffer.getFoldLevel(physicalLine) > 0) {
        foldPainter.paintFoldMiddle(this, gfx, line, physicalLine, y - textArea.getPainter().getLineExtraSpacing(), lineHeight, buffer);
    }
    //{{{ Paint line numbers
    if (info.firstSubregion && expanded) {
        String number = Integer.toString(physicalLine + 1);
        int offset;
        switch(alignment) {
            case RIGHT:
                offset = lineNumberWidth - (fm.stringWidth(number) + 1);
                break;
            case CENTER:
                offset = (lineNumberWidth - fm.stringWidth(number)) / 2;
                break;
            case LEFT:
            default:
                offset = 0;
                break;
        }
        if (physicalLine == textArea.getCaretLine() && currentLineHighlightEnabled) {
            gfx.setColor(currentLineHighlight);
        } else if (interval > 1 && (physicalLine + 1) % interval == 0)
            gfx.setColor(intervalHighlight);
        else
            gfx.setColor(getForeground());
        gfx.drawString(number, FOLD_MARKER_SIZE + offset, baseline + y);
    //}}}
    }
}