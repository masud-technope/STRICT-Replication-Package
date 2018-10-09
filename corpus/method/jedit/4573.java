//}}}
//{{{ _delete() method
/**
	 * Rename a favorite
	 * @param session no session needed you can give null
	 * @param from The old path (not the name)
	 * @param to the new name
	 * @param comp The component that will parent error dialog boxes
	 * @return true if the favorite having that old path exists
	 */
@Override
public boolean _rename(Object session, String from, String to, Component comp) {
    VFSFile[] favorites = getFavorites();
    for (VFSFile fav : favorites) {
        Favorite favorite = (Favorite) fav;
        if (favorite.getPath().equals(from)) {
            favorite.label = to;
            return true;
        }
    }
    return false;
}