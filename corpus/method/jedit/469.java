private boolean checkNull(String file) {
    if (file.trim().length() == 0) {
        message.setForeground(Color.red);
        message.setText(installer.getProperty("dir.null"));
        return false;
    } else
        return true;
}