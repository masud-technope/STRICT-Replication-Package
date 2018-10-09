//}}}
//{{{ toggleExpanded() method
public void toggleExpanded(final int row) {
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
    Entry entry = model.files[row];
    if (entry.dirEntry.getType() == VFSFile.FILE)
        return;
    Runnable delayedAwtTask = new Runnable() {

        public void run() {
            setSelectedRow(row);
        }
    };
    if (entry.expanded) {
        model.collapse(VFSManager.getVFSForPath(entry.dirEntry.getPath()), row);
        resizeColumns();
        ThreadUtilities.runInDispatchThread(delayedAwtTask);
    } else {
        browserView.clearExpansionState();
        browserView.loadDirectory(entry, entry.dirEntry.getPath(), false, delayedAwtTask);
    }
}