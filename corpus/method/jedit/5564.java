 PerspectiveHandler(boolean restoreFiles) {
    this.restoreFiles = restoreFiles;
    restoreSplits = jEdit.getBooleanProperty("restore.splits", true);
    config = new View.ViewConfig();
    charData = new StringBuilder();
    config.docking = View.getDockingFrameworkProvider().createDockingLayout();
}