//}}}
//{{{ expandAllFolds() method
/**
	 * Expands all folds.
	 * @since jEdit 4.2pre1
	 */
public void expandAllFolds() {
    showLineRange(0, buffer.getLineCount() - 1);
    notifyScreenLineChanges();
    textArea.foldStructureChanged();
}