//{{{ getValueAt() method
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    Object obj = filteredEntries.get(rowIndex);
    if (obj instanceof String) {
        if (columnIndex == 1)
            return obj;
        else
            return null;
    } else {
        Entry entry = (Entry) obj;
        switch(columnIndex) {
            case 0:
                return entry.install;
            case 1:
                return entry.name;
            case 2:
                return entry.set;
            case 3:
                if ((entry.installedVersion != null) && !entry.installedVersion.equals(entry.version))
                    return entry.installedVersion + "->" + entry.version;
                return entry.version;
            case 4:
                return formatSize(entry.size);
            case 5:
                return entry.date;
            default:
                throw new Error("Column out of range");
        }
    }
//}}}
}