private String getPrevOrNextFile(View view, String path, Direction direction) {
    if (files == null)
        files = _getFiles(view);
    if (files == null || files.length == 0)
        return null;
    if (path == null) {
        path = view.getBuffer().getSymlinkPath();
        VFS vfs = VFSManager.getVFSForPath(path);
        boolean ignoreCase = ((vfs.getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0);
        for (String file : files) {
            if (StandardUtilities.compareStrings(file, path, ignoreCase) == 0) {
                return path;
            }
        }
        if (direction == Direction.NEXT) {
            return getFirstFile(view);
        } else {
            return getLastFile(view);
        }
    } else {
        // -1 so that the last isn't checked
        VFS vfs = VFSManager.getVFSForPath(path);
        boolean ignoreCase = ((vfs.getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0);
        if (direction == Direction.NEXT && StandardUtilities.compareStrings(files[files.length - 1], path, ignoreCase) == 0) {
            // Going forward and already at the last file
            return null;
        } else if (direction == Direction.PREV && StandardUtilities.compareStrings(files[0], path, ignoreCase) == 0) {
            // Going backward and already at the first file
            return null;
        }
        for (int i = 0; i < files.length - 1; i++) {
            if (StandardUtilities.compareStrings(files[i], path, ignoreCase) == 0) {
                if (direction == Direction.NEXT)
                    return files[i + 1];
                else {
                    if (i == 0)
                        return files[files.length - 1];
                    return files[i - 1];
                }
            }
        }
        return null;
    }
}