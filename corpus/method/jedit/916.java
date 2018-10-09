//}}}
//{{{ collapse() method
public void collapse(VFS vfs, int index) {
    Entry entry = files[index];
    if (!entry.expanded)
        return;
    entry.expanded = false;
    int lastIndex = index + 1;
    while (lastIndex < files.length) {
        Entry e = files[lastIndex];
        if (e.level <= entry.level)
            break;
        lastIndex++;
        if (e.expanded) {
            removeExtendedAttributes(VFSManager.getVFSForPath(e.dirEntry.getPath()));
        }
    }
    removeExtendedAttributes(vfs);
    Entry[] newFiles = new Entry[files.length - lastIndex + index + 1];
    System.arraycopy(files, 0, newFiles, 0, index + 1);
    System.arraycopy(files, lastIndex, newFiles, index + 1, files.length - lastIndex);
    files = newFiles;
    /* fireTableRowsUpdated(index,index);
		fireTableRowsDeleted(index + 1,lastIndex); */
    fireTableStructureChanged();
}