public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source instanceof JRadioButton)
        updateEnabled();
    if (source == ok)
        ok();
    else if (source == cancel)
        cancel();
    else if (source == combo)
        updateList();
    else if (source == fileButton) {
        String directory;
        if (fileIcon == null)
            directory = null;
        else
            directory = MiscUtilities.getParentOfPath(fileIcon);
        String[] paths = GUIUtilities.showVFSFileDialog(null, directory, VFSBrowser.OPEN_DIALOG, false);
        if (paths == null)
            return;
        fileIcon = "file:" + paths[0];
        try {
            fileButton.setIcon(new ImageIcon(new URL(fileIcon)));
        } catch (MalformedURLException mf) {
            Log.log(Log.ERROR, this, mf);
        }
        fileButton.setText(MiscUtilities.getFileName(fileIcon));
    }
}