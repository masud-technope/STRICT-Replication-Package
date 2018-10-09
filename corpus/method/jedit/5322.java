//}}}
//{{{ _save() method
public void _save() {
    String[] dirs = { "favorites", "home", "last", "buffer", "working" };
    jEdit.setProperty("vfs.browser.defaultPath", dirs[defaultDirectory.getSelectedIndex()]);
    jEdit.setBooleanProperty("vfs.browser.showToolbar", showToolbar.isSelected());
    jEdit.setBooleanProperty("vfs.browser.showMenubar", showMenubar.isSelected());
    jEdit.setBooleanProperty("vfs.browser.showIcons", showIcons.isSelected());
    jEdit.setBooleanProperty("vfs.browser.showHiddenFiles", showHiddenFiles.isSelected());
    jEdit.setBooleanProperty("vfs.browser.sortIgnoreCase", sortIgnoreCase.isSelected());
    jEdit.setBooleanProperty("vfs.browser.sortMixFilesAndDirs", sortMixFilesAndDirs.isSelected());
    jEdit.setBooleanProperty("vfs.browser.doubleClickClose", doubleClickClose.isSelected());
    jEdit.setBooleanProperty("vfs.browser.currentBufferFilter", currentBufferFilter.isSelected());
    jEdit.setBooleanProperty("vfs.browser.useDefaultIcons", useDefaultIcons.isSelected());
}