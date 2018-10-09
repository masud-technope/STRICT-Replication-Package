//}}}
//{{{ find() method
/**
	 * Finds the next occurrence of the search string.
	 * @param view The view
	 * @return True if the operation was successful, false otherwise
	 */
public static boolean find(View view) {
    // component that will parent any dialog boxes
    Component comp = SearchDialog.getSearchDialog(view);
    if (comp == null || !comp.isShowing())
        comp = view;
    String path = fileset.getNextFile(view, null);
    if (path == null) {
        GUIUtilities.error(comp, "empty-fileset", null);
        return false;
    }
    try {
        view.showWaitCursor();
        SearchMatcher matcher = getSearchMatcher();
        if (matcher == null) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return false;
        }
        record(view, "find(view)", false, true);
        boolean repeat = false;
        loop: for (; ; ) {
            while (path != null) {
                Buffer buffer = jEdit.openTemporary(view, null, path, false);
                /* this is stupid and misleading.
					 * but 'path' is not used anywhere except
					 * the above line, and if this is done
					 * after the 'continue', then we will
					 * either hang, or be forced to duplicate
					 * it inside the buffer == null, or add
					 * a 'finally' clause. you decide which one's
					 * worse. */
                if (reverse) {
                    path = fileset.getPrevFile(view, path);
                } else {
                    path = fileset.getNextFile(view, path);
                }
                if (buffer == null)
                    continue loop;
                // Wait for the buffer to load
                if (!buffer.isLoaded())
                    TaskManager.instance.waitForIoTasks();
                int start;
                if (view.getBuffer() == buffer && !repeat) {
                    JEditTextArea textArea = view.getTextArea();
                    Selection s = textArea.getSelectionAtOffset(textArea.getCaretPosition());
                    if (s == null)
                        start = textArea.getCaretPosition();
                    else if (reverse)
                        start = s.getStart();
                    else
                        start = s.getEnd();
                } else if (reverse)
                    start = buffer.getLength();
                else
                    start = 0;
                if (find(view, buffer, start, repeat, reverse))
                    return true;
            }
            if (repeat) {
                if (!BeanShell.isScriptRunning()) {
                    view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.search-not-found"));
                    javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                }
                return false;
            }
            boolean restart;
            // interactively, ask the user what to do.
            if (wrap) {
                if (!BeanShell.isScriptRunning()) {
                    view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.auto-wrap"));
                    // beep if beep property set
                    if (jEdit.getBooleanProperty("search.beepOnSearchAutoWrap")) {
                        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                    }
                }
                restart = true;
            } else if (BeanShell.isScriptRunning()) {
                restart = false;
            } else {
                Integer[] args = { Integer.valueOf(reverse ? 1 : 0) };
                int result = GUIUtilities.confirm(comp, "keepsearching", args, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                restart = (result == JOptionPane.YES_OPTION);
            }
            if (restart) {
                // start search from beginning
                path = fileset.getFirstFile(view);
                repeat = true;
            } else
                break loop;
        }
    } catch (Exception e) {
        handleError(comp, e);
    } finally {
        view.hideWaitCursor();
    }
    return false;
}