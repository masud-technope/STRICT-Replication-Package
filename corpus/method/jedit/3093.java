@Override
public void ok() {
    // check values
    String modeName = getModeName();
    if (modeName == null || modeName.isEmpty()) {
        JOptionPane.showMessageDialog(jEdit.getActiveView(), jEdit.getProperty("options.editing.addMode.dialog.Mode_name_may_not_be_empty.", "Mode name may not be empty."), jEdit.getProperty("options.editing.addMode.dialog.errorTitle", "Error"), JOptionPane.ERROR_MESSAGE);
        return;
    }
    String modeFile = getModeFile();
    if (modeFile == null || modeFile.isEmpty()) {
        JOptionPane.showMessageDialog(jEdit.getActiveView(), jEdit.getProperty("options.editing.addMode.dialog.Mode_file_may_not_be_empty.", "Mode file may not be empty."), jEdit.getProperty("options.editing.addMode.dialog.errorTitle", "Error"), JOptionPane.ERROR_MESSAGE);
        return;
    }
    String filenameGlob = getFilenameGlob();
    String firstLineGlob = getFirstLineGlob();
    if ((filenameGlob == null || filenameGlob.isEmpty()) && (firstLineGlob == null || firstLineGlob.isEmpty())) {
        JOptionPane.showMessageDialog(jEdit.getActiveView(), jEdit.getProperty("options.editing.addMode.dialog.Either_file_name_glob_or_first_line_glob_or_both_must_be_filled_in.", "Either file name glob or first line glob or both must be filled in."), jEdit.getProperty("options.editing.addMode.dialog.errorTitle", "Error"), JOptionPane.ERROR_MESSAGE);
        return;
    }
    canceled = false;
    dispose();
}