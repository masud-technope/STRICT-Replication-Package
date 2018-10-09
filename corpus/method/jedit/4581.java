//}}}
//{{{ getFavorites() method
public static VFSFile[] getFavorites() {
    synchronized (lock) {
        if (favorites == null)
            loadFavorites();
        return favorites.toArray(new VFSFile[favorites.size()]);
    }
}