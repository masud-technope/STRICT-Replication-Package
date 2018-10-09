//}}}
//{{{ collapseFold() method
/**
	 * Collapses the fold at the specified physical line index.
	 * @param line A physical line index
	 * @since jEdit 4.2pre1
	 */
public void collapseFold(int line) {
    int lineCount = buffer.getLineCount();
    int end = lineCount - 1;
    // parent fold
    if (line != 0 && line != lineCount - 1 && buffer.isFoldStart(line) && !isLineVisible(line + 1)) {
        line--;
    }
    int initialFoldLevel = buffer.getFoldLevel(line);
    //{{{ Find fold start and end...
    int start = 0;
    if (line != lineCount - 1 && buffer.getFoldLevel(line + 1) > initialFoldLevel) {
        // this line is the start of a fold
        start = line + 1;
        for (int i = line + 1; i < lineCount; i++) {
            if (buffer.getFoldLevel(i) <= initialFoldLevel) {
                end = i - 1;
                break;
            }
        }
    } else {
        boolean ok = false;
        // scan backwards looking for the start
        for (int i = line - 1; i >= 0; i--) {
            if (buffer.getFoldLevel(i) < initialFoldLevel) {
                start = i + 1;
                ok = true;
                break;
            }
        }
        if (!ok) {
            // no folds in buffer
            return;
        }
        for (int i = line + 1; i < lineCount; i++) {
            if (buffer.getFoldLevel(i) < initialFoldLevel) {
                end = i - 1;
                break;
            }
        }
    //}}}
    }
    // Collapse the fold...
    hideLineRange(start, end);
    notifyScreenLineChanges();
    textArea.foldStructureChanged();
}