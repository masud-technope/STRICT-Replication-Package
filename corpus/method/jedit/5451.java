public void actionPerformed(ActionEvent e) {
    String[] choosenFolder = GUIUtilities.showVFSFileDialog(null, autosaveDirectory.getText(), VFSBrowser.CHOOSE_DIRECTORY_DIALOG, false);
    if (choosenFolder != null)
        autosaveDirectory.setText(choosenFolder[0]);
}