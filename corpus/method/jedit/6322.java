public void actionPerformed(ActionEvent evt) {
    String path = MiscUtilities.expandVariables(directoryField.getText());
    directoryField.setText(path);
    if (evt.getSource() == choose) {
        String[] dirs = GUIUtilities.showVFSFileDialog(SearchDialog.this, view, path, VFSBrowser.CHOOSE_DIRECTORY_DIALOG, false);
        if (dirs != null)
            directoryField.setText(dirs[0]);
    } else if (evt.getSource() == synchronize) {
        synchronizeMultiFileSettings();
    } else // source is directory or filter field
    {
        // just as if Enter was pressed in another
        // text field
        ok();
    }
}