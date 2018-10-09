@Override
public void endElement(String uri, String localName, String name) {
    if (name.equals("BUFFER")) {
        if (restoreFiles && !skipRemote(charData.toString())) {
            boolean bufferUntitled = false;
            if (untitled != null) {
                bufferUntitled = "TRUE".equals(untitled);
            }
            Buffer restored = jEdit.openTemporary(null, null, charData.toString(), bufferUntitled, null, bufferUntitled);
            // it's sufficient to check whether they are present on the first BUFFER element
            if (restored != null) {
                if (autoReload != null)
                    restored.setAutoReload("TRUE".equals(autoReload));
                if (autoReloadDialog != null)
                    restored.setAutoReloadDialog("TRUE".equals(autoReloadDialog));
                if (untitled != null)
                    restored.setUntitled(bufferUntitled);
                jEdit.commitTemporary(restored);
            }
        }
    } else if (name.equals("PANES")) {
        SplitConfigParser parser = new SplitConfigParser(charData.toString());
        parser.setIncludeSplits(restoreSplits);
        parser.setIncludeFiles(restoreFiles);
        parser.setIncludeRemoteFiles(jEdit.getBooleanProperty("restore.remote"));
        config.splitConfig = parser.parse();
    } else if (name.equals("VIEW")) {
        if (config.docking != null)
            config.docking.loadLayout(PERSPECTIVE_FILENAME, jEdit.getViewCount());
        view = jEdit.newView(view, null, config);
        config = new View.ViewConfig();
        config.docking = View.getDockingFrameworkProvider().createDockingLayout();
    } else if (name.equals("TITLE"))
        config.title = charData.toString();
}