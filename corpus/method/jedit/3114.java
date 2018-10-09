static String makeToolTipText(String path, Boolean isBackup) {
    String text = path;
    if (isBackup)
        text = String.format("(backup file?) %s", text);
    return text;
}