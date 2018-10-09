//}}}
//{{{ saveFavorites() method
public static void saveFavorites() {
    synchronized (lock) {
        if (favorites == null)
            return;
        int i = 0;
        for (Favorite favorite : favorites) {
            String p = favorite.getPath();
            String l = favorite.getLabel();
            jEdit.setProperty("vfs.favorite." + i, p);
            if (p.equals(l) || MiscUtilities.abbreviate(p).equals(l))
                jEdit.unsetProperty("vfs.favorite." + i + ".label");
            else
                jEdit.setProperty("vfs.favorite." + i + ".label", l);
            jEdit.setIntegerProperty("vfs.favorite." + i + ".type", favorite.getType());
            i++;
        }
        jEdit.unsetProperty("vfs.favorite." + favorites.size());
        jEdit.unsetProperty("vfs.favorite." + favorites.size() + ".type");
    }
}