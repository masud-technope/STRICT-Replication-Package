static void updateStyle(JComponent target, boolean isBackup, String path) {
    String styleName = isBackup ? "backup" : "normal";
    switch(styleName) {
        case "backup":
            target.setForeground(new Color(230, 207, 93));
            break;
        case "normal":
        default:
            target.setForeground(defaultColor);
            break;
    }
    target.setToolTipText(path != null ? makeToolTipText(path, isBackup) : null);
}