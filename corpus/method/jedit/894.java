public int compare(Entry entry1, Entry entry2) {
    // we want to compare sibling ancestors of the entries
    if (entry1.level < entry2.level)
        return compare(entry1, entry2.parent);
    if (entry1.level > entry2.level)
        return compare(entry1.parent, entry2);
    // here we have entries of the same level
    if (entry1.parent != entry2.parent)
        return compare(entry1.parent, entry2.parent);
    // here we have siblings with the same parents
    // let's do the real comparison
    VFSFile file1 = entry1.dirEntry;
    VFSFile file2 = entry2.dirEntry;
    if (!sortMixFilesAndDirs) {
        if (file1.getType() != file2.getType())
            return file2.getType() - file1.getType();
    }
    int result;
    // if the modified attribute is present, then we have a LocalFile
    if (sortAttribute == VFS.EA_MODIFIED)
        result = ((Long) file1.getModified()).compareTo((Long) file2.getModified());
    else // sort by size
    if (sortAttribute == VFS.EA_SIZE)
        result = ((Long) file1.getLength()).compareTo((Long) file2.getLength());
    else // sort by type (= extension)
    if (sortAttribute == VFS.EA_TYPE)
        result = StandardUtilities.compareStrings(entry1.extension, entry2.extension, sortIgnoreCase);
    else
        // default: sort by name
        result = StandardUtilities.compareStrings(file1.getName(), file2.getName(), sortIgnoreCase);
    return sortAscending ? result : -result;
}