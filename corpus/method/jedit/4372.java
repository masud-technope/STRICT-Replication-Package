private HelpIndex getHelpIndex() {
    if (index == null) {
        index = new HelpIndex();
        try {
            index.indexEditorHelp();
        } catch (Exception e) {
            index = null;
            Log.log(Log.ERROR, this, e);
            GUIUtilities.error(helpViewer.getComponent(), "helpviewer.search.error", new String[] { e.toString() });
        }
    }
    return index;
}