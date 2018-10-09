//}}}
//{{{ run() method
@Override
public void _run() {
    setStatus(jEdit.getProperty("hypersearch-status"));
    SearchFileSet fileset = SearchAndReplace.getSearchFileSet();
    String[] files = fileset.getFiles(view);
    if (files == null || files.length == 0) {
        ThreadUtilities.runInDispatchThread(new Runnable() {

            public void run() {
                GUIUtilities.error(view, "empty-fileset", null);
                results.searchDone(rootSearchNode);
            }
        });
        return;
    }
    setMaximum(fileset.getFileCount(view));
    // to minimize synchronization and stuff like that, we only
    // show a status message at most twice a second
    // initially zero, so that we always show the first message
    String searchingCaption = jEdit.getProperty("hypersearch-results.searching", new String[] { SearchAndReplace.getSearchString() }) + ' ';
    try {
        if (selection != null) {
            Buffer buffer = view.getBuffer();
            searchInSelection(buffer);
        } else {
            int current = 0;
            long lastStatusTime = 0L;
            int resultCount = 0;
            boolean asked = false;
            int maxResults = jEdit.getIntegerProperty("hypersearch.maxWarningResults");
            for (int i = 0; i < files.length; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    Log.log(Log.MESSAGE, this, "Search stopped by user action (stop button)");
                    break;
                }
                if (!asked && resultCount > maxResults && maxResults != 0) {
                    Log.log(Log.DEBUG, this, "Search in progress, " + resultCount + " occurrences found, asking the user to stop");
                    asked = true;
                    int ret = GUIUtilities.confirm(view, "hypersearch.tooManyResults", new Object[] { resultCount }, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ret == JOptionPane.YES_OPTION) {
                        Log.log(Log.MESSAGE, this, "Search stopped by user action");
                        break;
                    }
                }
                String file = files[i];
                current++;
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastStatusTime > 250L) {
                    setValue(current);
                    lastStatusTime = currentTime;
                    results.setSearchStatus(searchingCaption + file);
                }
                Buffer buffer = jEdit.openTemporary(null, null, file, false);
                if (buffer != null) {
                    // Wait for the buffer to load
                    if (!buffer.isLoaded())
                        TaskManager.instance.waitForIoTasks();
                    resultCount += doHyperSearch(buffer, 0, buffer.getLength());
                }
            }
            Log.log(Log.MESSAGE, this, resultCount + " OCCURENCES");
        }
    } catch (final Exception e) {
        Log.log(Log.ERROR, this, e);
        ThreadUtilities.runInDispatchThread(new Runnable() {

            public void run() {
                SearchAndReplace.handleError(view, e);
            }
        });
    } finally {
        ThreadUtilities.runInDispatchThread(new Runnable() {

            public void run() {
                results.searchDone(rootSearchNode, selectNode);
            }
        });
    }
}