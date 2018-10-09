//}}}
//{{{ setDirectory() method
public void setDirectory(VFS vfs, Object node, java.util.List<VFSFile> list, Set<String> tmpExpanded) {
    timer.stop();
    typeSelectBuffer.setLength(0);
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
    int startIndex;
    if (node == null) {
        startIndex = 0;
        model.setRoot(vfs, list);
    } else {
        startIndex = model.expand(vfs, (Entry) node, list);
        startIndex++;
    }
    for (int i = 0; i < list.size(); i++) {
        Entry e = model.files[startIndex + i];
        String path = e.dirEntry.getPath();
        if (tmpExpanded.contains(path)) {
            browserView.loadDirectory(e, path, false);
            tmpExpanded.remove(path);
        }
    }
    resizeColumns();
}