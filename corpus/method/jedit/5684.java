//{{{ getColumnName() method
@Override
public String getColumnName(int column) {
    switch(column) {
        case 0:
            return " ";
        case 1:
            return ' ' + jEdit.getProperty("install-plugins.info.name");
        case 2:
            return ' ' + jEdit.getProperty("install-plugins.info.category");
        case 3:
            return ' ' + jEdit.getProperty("install-plugins.info.version");
        case 4:
            return ' ' + jEdit.getProperty("install-plugins.info.size");
        case 5:
            return ' ' + jEdit.getProperty("install-plugins.info.releaseDate");
        default:
            throw new Error("Column out of range");
    }
//}}}
}