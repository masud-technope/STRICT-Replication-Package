//{{{ getColumnName() method
@Override
public String getColumnName(int column) {
    switch(column) {
        case 0:
            return " ";
        case 1:
            return jEdit.getProperty("manage-plugins.info.name");
        case 2:
            return jEdit.getProperty("manage-plugins.info.version");
        case 3:
            return jEdit.getProperty("manage-plugins.info.status");
        case 4:
            return jEdit.getProperty("manage-plugins.info.data");
        default:
            throw new Error("Column out of range");
    }
//}}}
}