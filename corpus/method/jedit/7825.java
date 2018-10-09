public void migrate() {
    if ((jEdit.getIntegerProperty("checkFileStatus", GeneralOptionPane.checkFileStatus_focus) == 0))
        jEdit.setIntegerProperty("checkFileStatus", GeneralOptionPane.checkFileStatus_focus);
}