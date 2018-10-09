public void updateStyle(Buffer buffer) {
    String path = buffer.getPath();
    Boolean isBackup = buffer.isBackup();
    updateStyle(this, isBackup, path);
}