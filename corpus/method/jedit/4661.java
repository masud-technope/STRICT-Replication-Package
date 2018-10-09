public int compare(VFSFile file1, VFSFile file2) {
    if (!sortMixFilesAndDirs) {
        if (file1.getType() != file2.getType())
            return file2.getType() - file1.getType();
    }
    return StandardUtilities.compareStrings(file1.getName(), file2.getName(), sortIgnoreCase);
}