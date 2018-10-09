//}}}
//{{{ propertiesChanged() method
public void propertiesChanged() {
    showIcons = jEdit.getBooleanProperty("vfs.browser.showIcons");
    table.propertiesChanged();
    splitPane.setBorder(null);
}