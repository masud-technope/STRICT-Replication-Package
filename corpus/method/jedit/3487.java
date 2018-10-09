//}}}
//{{{ ok() method
@Override
public void ok() {
    if (nameTextField != null) {
        VFSFile vfsFile = browser.getSelectedFiles()[0];
        if ((vfsFile.getVFS().getCapabilities() & VFS.RENAME_CAP) != 0) {
            browser.rename(vfsFile, nameTextField.getText());
        }
    }
    GUIUtilities.saveGeometry(this, "propdialog");
    setVisible(false);
}