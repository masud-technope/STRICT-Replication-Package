//{{{ getValueAt() method
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    Entry entry = entries.get(rowIndex);
    switch(columnIndex) {
        case 0:
            return Boolean.valueOf(!entry.status.equals(Entry.NOT_LOADED) && !entry.status.equals(Entry.DISABLED));
        case 1:
            if (entry.name == null) {
                return MiscUtilities.getFileName(entry.jar);
            } else {
                return entry.name;
            }
        case 2:
            return entry.version;
        case 3:
            return jEdit.getProperty("plugin-manager.status." + entry.status);
        case 4:
            if (entry.dataSize == null && entry.plugin != null) {
                File pluginDirectory = entry.plugin.getPluginHome();
                if (null == pluginDirectory) {
                    return null;
                }
                if (pluginDirectory.exists()) {
                    entry.dataSize = StandardUtilities.formatFileSize(IOUtilities.fileLength(pluginDirectory));
                } else {
                    if (jEdit.getBooleanProperty("plugin." + entry.clazz + ".usePluginHome")) {
                        entry.dataSize = StandardUtilities.formatFileSize(0);
                    } else {
                        entry.dataSize = jEdit.getProperty("manage-plugins.data-size.unknown");
                    }
                }
            }
            return entry.dataSize;
        default:
            throw new Error("Column out of range");
    }
//}}}
}