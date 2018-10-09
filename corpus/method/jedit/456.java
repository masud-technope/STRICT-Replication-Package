boolean isOK() {
    if (installDir.getText().length() == 0)
        return false;
    File f = new File(installDir.getText());
    return !(f.exists() && !f.isDirectory());
}