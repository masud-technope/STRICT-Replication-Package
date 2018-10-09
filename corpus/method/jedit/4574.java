//}}}
//{{{ loadFavorites() method
public static void loadFavorites() {
    synchronized (lock) {
        favorites = new LinkedList<Favorite>();
        String favoritePath;
        int i = 0;
        while ((favoritePath = jEdit.getProperty("vfs.favorite." + i)) != null) {
            Favorite favorite = new Favorite(favoritePath, jEdit.getIntegerProperty("vfs.favorite." + i + ".type", VFSFile.DIRECTORY));
            favorites.add(favorite);
            String label = jEdit.getProperty("vfs.favorite." + i + ".label");
            if (label != null) {
                favorite.label = label;
            }
            i++;
        }
    }
}