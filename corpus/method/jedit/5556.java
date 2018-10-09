//}}}
//{{{ _save() method
@Override
protected void _save() {
    jEdit.setBooleanProperty("view.docking.alternateLayout", layout.getIcon() == layoutIcon2 || layout.getIcon() == layoutIcon4);
    jEdit.setBooleanProperty("view.toolbar.alternateLayout", layout.getIcon() == layoutIcon3 || layout.getIcon() == layoutIcon4);
    jEdit.setBooleanProperty("view.abbreviatePaths", abbreviatePaths.isSelected());
    jEdit.setBooleanProperty("view.showFullPath", showFullPath.isSelected());
    jEdit.setBooleanProperty("view.toolbar.floatable", floatableToolbars.isSelected());
    jEdit.setBooleanProperty("view.showSearchbar", showSearchbar.isSelected());
    jEdit.setBooleanProperty("search.beepOnSearchAutoWrap", beepOnSearchAutoWrap.isSelected());
    jEdit.setBooleanProperty("view.showBufferSwitcher", showBufferSwitcher.isSelected());
    jEdit.setBooleanProperty("bufferswitcher.sortBuffers", sortBufferSwitcher.isSelected());
    jEdit.setBooleanProperty("bufferswitcher.sortByName", sortBufferSwitcherByName.isSelected());
    jEdit.setProperty("bufferSwitcher.maxRowCount", bufferSwitcherMaxRowCount.getText());
    jEdit.setProperty("bufferset.scope", buffersetScope.getSelectedItem().toString());
    jEdit.setBooleanProperty("sortBuffers", sortBuffers.isSelected());
    jEdit.setBooleanProperty("sortByName", sortByName.isSelected());
    jEdit.setBooleanProperty("fullScreenIncludesMenu", fullScreenIncludesMenu.isSelected());
    jEdit.setBooleanProperty("fullScreenIncludesToolbar", fullScreenIncludesToolbar.isSelected());
    jEdit.setBooleanProperty("fullScreenIncludesStatus", fullScreenIncludesStatus.isSelected());
}