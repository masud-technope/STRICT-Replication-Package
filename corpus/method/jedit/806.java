//}}}
//{{{ rename() methods
/**
	 * Rename a file.
	 * It will prompt for the new name.
	 * @param from the file to rename
	 * @since jEdit 4.5pre1
	 */
public void rename(VFSFile from) {
    String filename;
    if (from instanceof FavoritesVFS.Favorite) {
        FavoritesVFS.Favorite favorite = (FavoritesVFS.Favorite) from;
        filename = favorite.getLabel();
    } else {
        filename = from.getName();
    }
    String[] args = { filename };
    String to = GUIUtilities.input(this, "vfs.browser.rename", args, filename);
    if (to == null)
        return;
    rename(from.getVFS(), from.getPath(), to);
}