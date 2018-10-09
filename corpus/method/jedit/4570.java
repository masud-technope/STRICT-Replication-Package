//{{{ FavoritesVFS constructor
public  FavoritesVFS() {
    super("favorites", DELETE_CAP | RENAME_CAP | LOW_LATENCY_CAP | NON_AWT_SESSION_CAP, new String[] { EA_TYPE });
    /* addToFavorites(), which is a static method
		 * (for convinience) needs an instance of the
		 * VFS to pass to VFSManager.sendVFSUpdate(),
		 * hence this hack. */
    instance = this;
}