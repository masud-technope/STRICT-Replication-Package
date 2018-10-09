//{{{ FavoritesMenuButton constructor
 FavoritesMenuButton() {
    setText(jEdit.getProperty("vfs.browser.favorites.label"));
    GenericGUIUtilities.setAutoMnemonic(this);
    setName("favorites");
    createPopupMenu();
//}}}
}