//}}}
//{{{ replaceAll() method
/**
	 * Replaces all occurrences of the search string with the replacement
	 * string.
	 * @param view The view
	 * @param dontOpenChangedFiles Whether to open changed files or to autosave them quietly
	 * @return the number of modified files
	 */
public static boolean replaceAll(View view, boolean dontOpenChangedFiles) {
    // component that will parent any dialog boxes
    Component comp = SearchDialog.getSearchDialog(view);
    if (comp == null)
        comp = view;
    if (fileset.getFileCount(view) == 0) {
        GUIUtilities.error(comp, "empty-fileset", null);
        return false;
    }
    record(view, "replaceAll(view)", true, true);
    view.showWaitCursor();
    boolean smartCaseReplace = getSmartCaseReplace();
    int fileCount = 0;
    int occurCount = 0;
    try {
        SearchMatcher matcher = getSearchMatcher();
        if (matcher == null)
            return false;
        initReplace();
        String path = fileset.getFirstFile(view);
        loop: while (path != null) {
            Buffer buffer = jEdit.openTemporary(view, null, path, false);
            /* this is stupid and misleading.
				 * but 'path' is not used anywhere except
				 * the above line, and if this is done
				 * after the 'continue', then we will
				 * either hang, or be forced to duplicate
				 * it inside the buffer == null, or add
				 * a 'finally' clause. you decide which one's
				 * worse. */
            path = fileset.getNextFile(view, path);
            if (buffer == null)
                continue loop;
            // Wait for buffer to finish loading
            if (buffer.isPerformingIO())
                TaskManager.instance.waitForIoTasks();
            if (!buffer.isEditable())
                continue loop;
            // Leave buffer in a consistent state if
            // an error occurs
            int retVal = 0;
            try {
                buffer.beginCompoundEdit();
                retVal = _replace(view, buffer, matcher, 0, buffer.getLength(), smartCaseReplace);
            } finally {
                buffer.endCompoundEdit();
            }
            if (retVal != 0) {
                fileCount++;
                occurCount += retVal;
                if (dontOpenChangedFiles) {
                    buffer.save(null, null);
                } else {
                    jEdit.commitTemporary(buffer);
                    jEdit.getBufferSetManager().addBuffer(view, buffer);
                }
            }
        }
    } catch (Exception e) {
        handleError(comp, e);
    } finally {
        view.hideWaitCursor();
    }
    /* Don't do this when playing a macro, cos it's annoying */
    if (!BeanShell.isScriptRunning()) {
        Object[] args = { Integer.valueOf(occurCount), Integer.valueOf(fileCount) };
        view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.replace-all", args));
        if (occurCount == 0)
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    }
    return (fileCount != 0);
}