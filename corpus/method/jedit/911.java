//}}}
//{{{ getColumnName() method
public String getColumnName(int col) {
    if (col == 0)
        return jEdit.getProperty("vfs.browser.name");
    else
        return jEdit.getProperty("vfs.browser." + getExtendedAttribute(col));
}