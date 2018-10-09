//}}}
//{{{ addToFavorites() method
public static void addToFavorites(String path, int type) {
    synchronized (lock) {
        if (favorites == null)
            loadFavorites();
        for (Favorite favorite : favorites) {
            if (favorite.getPath().equals(path))
                return;
        }
        favorites.add(new Favorite(path, type));
        VFSManager.sendVFSUpdate(instance, PROTOCOL + ':', false);
        EditBus.send(new DynamicMenuChanged("favorites"));
    }
}