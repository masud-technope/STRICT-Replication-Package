//}}}
//{{{ getDefaultIcon() method
/**
	 * Returns the default icon for the file.
	 *
	 * @since jEdit 4.3pre9
	 */
public final Icon getDefaultIcon(boolean expanded, boolean openBuffer) {
    if (getType() == DIRECTORY)
        return expanded ? FileCellRenderer.openDirIcon : FileCellRenderer.dirIcon;
    else if (getType() == FILESYSTEM)
        return FileCellRenderer.filesystemIcon;
    else if (openBuffer)
        return FileCellRenderer.openFileIcon;
    else
        return FileCellRenderer.fileIcon;
}