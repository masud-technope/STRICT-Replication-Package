//{{{ directoryLoaded() method
void directoryLoaded(Object node, Object[] loadInfo, boolean addToHistory) {
    String path = (String) loadInfo[0];
    if (path == null) {
        // there was an error
        return;
    }
    VFSFile[] list = (VFSFile[]) loadInfo[1];
    if (node == null) {
        // This is the new, canonical path
        VFSBrowser.this.path = path;
        if (!pathField.getText().equals(path))
            pathField.setText(path);
        if (path.endsWith("/") || path.endsWith(File.separator)) {
            // ensure consistent history;
            // eg we don't want both
            // foo/ and foo
            path = path.substring(0, path.length() - 1);
        }
        if (addToHistory) {
            HistoryModel.getModel("vfs.browser.path").addItem(path);
        }
    }
    boolean filterEnabled = filterCheckbox.isSelected();
    List<VFSFile> directoryList = new ArrayList<VFSFile>();
    if (list != null) {
        VFSFileFilter filter = getVFSFileFilter();
        for (VFSFile file : list) {
            if (file.isHidden() && !showHiddenFiles) {
                continue;
            }
            if (filter != null && (filterEnabled || filter instanceof DirectoriesOnlyFilter) && !filter.accept(file)) {
                continue;
            }
            directoryList.add(file);
        }
        Collections.sort(directoryList, new VFS.DirectoryEntryCompare(sortMixFilesAndDirs, sortIgnoreCase));
    }
    browserView.directoryLoaded(node, path, directoryList);
    // check. otherwise poor Rick will go insane.
    if (mode == CHOOSE_DIRECTORY_DIALOG)
        filesSelected();
}