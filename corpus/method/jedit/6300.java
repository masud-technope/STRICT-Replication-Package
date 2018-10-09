//}}}
//{{{ propertiesChanged() method
public void propertiesChanged() {
    // Option may have been changed
    isRemovable = !jEdit.getBooleanProperty("view.showSearchbar");
    Log.log(Log.DEBUG, this, "in SearchBar.propertiesChanged(), isRemovable = " + isRemovable);
    setCloseButtonVisibility();
}