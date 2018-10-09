//{{{ doTypeSelect() method
private boolean doTypeSelect(String str, int start, int end, boolean dirsOnly) {
    VFSFile[] files = ((VFSDirectoryEntryTableModel) getModel()).getFiles();
    int index = VFSFile.findCompletion(files, start, end, str, dirsOnly);
    if (index != -1) {
        setSelectedRow(index);
        return true;
    } else
        return false;
}