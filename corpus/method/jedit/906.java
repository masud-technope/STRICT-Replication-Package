//}}}
//{{{ getSortAttribute() method
public String getSortAttribute(int column) {
    return column == 0 ? "name" : getExtendedAttribute(column);
}