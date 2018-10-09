//{{{ synchronizeMultiFileSettings() method
private void synchronizeMultiFileSettings() {
    // don't sync search directory when "search all buffers" is active
    if (searchDirectory.isSelected()) {
        directoryField.setText(view.getBuffer().getDirectory());
    }
    if (!jEdit.getBooleanProperty("search.dontSyncFilter", false)) {
        filter.setText('*' + MiscUtilities.getFileExtension(view.getBuffer().getName()));
    }
//}}}
}