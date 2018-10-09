//{{{ propertiesChanged() method
void propertiesChanged() {
    showIcons = jEdit.getBooleanProperty("vfs.browser.showIcons");
    defaultIcons = jEdit.getBooleanProperty("vfs.browser.useDefaultIcons");
}