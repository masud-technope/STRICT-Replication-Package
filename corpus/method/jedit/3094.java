public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == browse) {
        View view = jEdit.getActiveView();
        String path = jEdit.getSettingsDirectory();
        int type = VFSBrowser.OPEN_DIALOG;
        boolean multiSelect = false;
        String[] filename = GUIUtilities.showVFSFileDialog(view, path, type, multiSelect);
        if (filename != null && filename.length > 0) {
            modeFile.setText(filename[0]);
        } else {
            modeFile.setText("");
        }
    } else if (source == ok) {
        ok();
    } else if (source == cancel) {
        cancel();
    }
}