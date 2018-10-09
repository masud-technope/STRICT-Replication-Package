@Override
public Icon getIcon(boolean expanded, boolean openBuffer) {
    if (icon == null) {
        if (fsView == null)
            fsView = FileSystemView.getFileSystemView();
        icon = fsView.getSystemIcon(file);
    }
    return icon;
}