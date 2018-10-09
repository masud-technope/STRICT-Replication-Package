//}}}
//{{{ expand() method
public int expand(VFS vfs, Entry entry, List<VFSFile> list) {
    int startIndex = -1;
    for (int i = 0; i < files.length; i++) {
        if (files[i] == entry)
            startIndex = i;
    }
    if (startIndex != -1)
        collapse(vfs, startIndex);
    addExtendedAttributes(vfs);
    entry.expanded = true;
    if (list != null) {
        // make a large enough destination array
        Entry[] newFiles = new Entry[files.length + list.size()];
        Entry[] subdirFiles = new Entry[list.size()];
        for (int i = 0; i < list.size(); i++) {
            subdirFiles[i] = new Entry(list.get(i), entry.level + 1, entry);
        }
        // sort expanded entries according to current sort params
        Arrays.sort(subdirFiles, new EntryCompare(getSortAttribute(sortColumnIndex), ascending));
        // make room after expanded entry for subdir files
        int nextIndex = startIndex + 1;
        System.arraycopy(files, 0, newFiles, 0, nextIndex);
        System.arraycopy(subdirFiles, 0, newFiles, nextIndex, list.size());
        System.arraycopy(files, nextIndex, newFiles, nextIndex + list.size(), files.length - nextIndex);
        this.files = newFiles;
    /* fireTableRowsInserted(startIndex + 1,
				startIndex + list.size() + 1); */
    }
    /* fireTableRowsUpdated(startIndex,startIndex); */
    fireTableStructureChanged();
    return startIndex;
}