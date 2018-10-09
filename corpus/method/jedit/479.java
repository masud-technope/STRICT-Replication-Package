private boolean checkExistNotDirectory(String dir) {
    File f = new File(dir);
    if (f.exists() && !f.isDirectory()) {
        message.setForeground(Color.red);
        message.setText(installer.getProperty("dir.not-directory"));
        return false;
    } else
        return true;
}