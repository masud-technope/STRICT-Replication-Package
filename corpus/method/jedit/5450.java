public void actionPerformed(ActionEvent e) {
    String[] choosenFolder = GUIUtilities.showVFSFileDialog(null, backupDirectory.getText(), VFSBrowser.CHOOSE_DIRECTORY_DIALOG, false);
    if (choosenFolder != null)
        backupDirectory.setText(choosenFolder[0]);
}