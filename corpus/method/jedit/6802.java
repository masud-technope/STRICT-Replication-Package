//{{{ mousePressed() method
public void mousePressed(MouseEvent e) {
    textArea.requestFocus();
    boolean outsideGutter = (e.getX() >= getWidth() - borderWidth * 2);
    if (TextAreaMouseHandler.isPopupTrigger(e) || outsideGutter) {
        if ((selectionPopupHandler != null) && (!outsideGutter) && (e.getX() > FOLD_MARKER_SIZE)) {
            int screenLine = e.getY() / textArea.getPainter().getLineHeight();
            int line = textArea.chunkCache.getLineInfo(screenLine).physicalLine;
            if (line >= 0) {
                selectionPopupHandler.handlePopup(e.getX(), e.getY(), line);
                return;
            }
        }
        e.translatePoint(-getWidth(), 0);
        textArea.mouseHandler.mousePressed(e);
        drag = true;
    } else {
        JEditBuffer buffer = textArea.getBuffer();
        int screenLine = e.getY() / textArea.getPainter().getLineHeight();
        int line = textArea.chunkCache.getLineInfo(screenLine).physicalLine;
        if (line == -1)
            return;
        if (e.getX() >= FOLD_MARKER_SIZE) {
            selectionStart = textArea.getLineStartOffset(line);
            int selectionEnd = getFoldEndOffset(line);
            Selection s = new Selection.Range(selectionStart, selectionEnd);
            if (textArea.isMultipleSelectionEnabled())
                textArea.addToSelection(s);
            else
                textArea.setSelection(s);
            textArea.moveCaretPosition(selectionEnd, false);
            selectLines = true;
            selAnchorLine = line;
            return;
        }
        //{{{ Determine action
        String defaultAction;
        String variant;
        if (buffer.isFoldStart(line)) {
            defaultAction = "toggle-fold";
            variant = "fold";
        } else if (structureHighlight && textArea.isStructureHighlightVisible() && textArea.lineInStructureScope(line)) {
            defaultAction = "match-struct";
            variant = "struct";
        } else
            return;
        String action = null;
        if (mouseActions != null)
            action = mouseActions.getActionForEvent(e, variant);
        if (action == null)
            action = defaultAction;
        //}}}
        //{{{ Handle actions
        StructureMatcher.Match match = textArea.getStructureMatch();
        if (action.equals("select-fold")) {
            textArea.displayManager.expandFold(line, true);
            textArea.selectFold(line);
        } else if (action.equals("narrow-fold")) {
            int[] lines = buffer.getFoldAtLine(line);
            textArea.displayManager.narrow(lines[0], lines[1]);
        } else if (action.startsWith("toggle-fold")) {
            if (textArea.displayManager.isLineVisible(line + 1)) {
                textArea.collapseFold(line);
            } else {
                if (action.endsWith("-fully")) {
                    textArea.displayManager.expandFold(line, true);
                } else {
                    textArea.displayManager.expandFold(line, false);
                }
            }
        } else if (action.equals("match-struct")) {
            if (match != null)
                textArea.setCaretPosition(match.end);
        } else if (action.equals("select-struct")) {
            if (match != null) {
                match.matcher.selectMatch(textArea);
            }
        } else if (action.equals("narrow-struct")) {
            if (match != null) {
                int start = Math.min(match.startLine, textArea.getCaretLine());
                int end = Math.max(match.endLine, textArea.getCaretLine());
                textArea.displayManager.narrow(start, end);
            }
        //}}}
        }
    }
//}}}
}