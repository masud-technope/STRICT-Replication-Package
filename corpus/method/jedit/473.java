private boolean checkExistNotEmpty(String dir) {
    File f = new File(dir);
    String[] cnt = f.list();
    if (cnt != null && cnt.length > 0) {
        message.setForeground(Color.orange);
        message.setText(installer.getProperty("dir.not-empty"));
        return false;
    } else
        return true;
}