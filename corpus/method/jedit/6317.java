//}}}
//{{{ updateEnabled() method
private void updateEnabled() {
    wrap.setEnabled(!hyperSearch.isSelected() && !searchSelection.isSelected());
    boolean reverseEnabled = !hyperSearch.isSelected() && searchCurrentBuffer.isSelected();
    searchBack.setEnabled(reverseEnabled);
    searchForward.setEnabled(reverseEnabled);
    if (!reverseEnabled)
        searchForward.setSelected(true);
    filter.setEnabled(searchAllBuffers.isSelected() || searchDirectory.isSelected());
    boolean searchDirs = searchDirectory.isSelected();
    directoryField.setEnabled(searchDirs);
    choose.setEnabled(searchDirs);
    searchSubDirectories.setEnabled(searchDirs);
    skipHidden.setEnabled(searchDirs);
    skipBinaryFiles.setEnabled(searchDirs);
    synchronize.setEnabled(searchAllBuffers.isSelected() || searchDirectory.isSelected());
    findBtn.setEnabled(!searchSelection.isSelected() || hyperSearch.isSelected());
    replaceBtn.setEnabled(!hyperSearch.isSelected() && !searchSelection.isSelected());
    replaceAndFindBtn.setEnabled(!hyperSearch.isSelected() && !searchSelection.isSelected());
}