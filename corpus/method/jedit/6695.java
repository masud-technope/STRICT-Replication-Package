//}}}
//{{{ expandFolds() method
/**
	 * Expands all folds with the specified fold level.
	 * @param foldLevel The fold level
	 * @param update If true, notify the text area of a fold level change. Since this will
	 *   automatically move the caret if still inside a fold, this may not be what we want.
	 * @since jEdit 4.5
	 */
public void expandFolds(int foldLevel, boolean update) {
    if (buffer.getFoldHandler() instanceof IndentFoldHandler)
        foldLevel = (foldLevel - 1) * buffer.getIndentSize() + 1;
    int lineCount = buffer.getLineCount();
    int end = lineCount - 1;
    showLineRange(0, end);
    int leastFolded = -1;
    int firstInvisible = 0;
    for (int i = 0; i < lineCount; i++) {
        int level = buffer.getFoldLevel(i);
        // line to unfold it from
        if (leastFolded == -1 || level < leastFolded) {
            leastFolded = level;
        }
        if (level < foldLevel || level == leastFolded) {
            if (firstInvisible != i) {
                hideLineRange(firstInvisible, i - 1);
            }
            firstInvisible = i + 1;
        }
    }
    if (firstInvisible != lineCount)
        hideLineRange(firstInvisible, end);
    notifyScreenLineChanges();
    if (update && textArea.getDisplayManager() == this) {
        textArea.foldStructureChanged();
    }
}