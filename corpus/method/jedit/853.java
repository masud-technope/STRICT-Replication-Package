/**
	 * Rename a file
	 * @param vfs the VFS. It may be strange to give the VFS, but in
	 * case of FavoriteVFS we cannot know that it is favorite.
	 * @param from the full path name of the file to be renamed
	 * @param newname the new name (only filename, not full path)
	 * @since jEdit 4.5pre1
	 */
private void rename(VFS vfs, String from, String newname) {
    String filename = vfs.getFileName(from);
    String to = newname;
    if (to == null)
        return;
    if (!(vfs instanceof FavoritesVFS)) {
        if (filename.equals(newname))
            return;
        to = MiscUtilities.constructPath(vfs.getParentOfPath(from), to);
    }
    Object session = vfs.createVFSSession(from, this);
    if (session == null)
        return;
    if (!startRequest())
        return;
    Runnable delayedAWTRequest = new DelayedEndRequest();
    Task renameTask = new RenameBrowserTask(this, session, vfs, from, to, delayedAWTRequest);
    ThreadUtilities.runInBackground(renameTask);
}