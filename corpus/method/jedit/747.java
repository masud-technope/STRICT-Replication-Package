//}}}
//{{{ getIconForFile() method
public static Icon getIconForFile(VFSFile file, boolean expanded, boolean openBuffer) {
    if (defaultIcons)
        return file.getDefaultIcon(expanded, openBuffer);
    return file.getIcon(expanded, openBuffer);
}