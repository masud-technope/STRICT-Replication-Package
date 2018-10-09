//}}}
//{{{ searchChildren() method
public ColumnBlock searchChildren(int line) {
    if (children != null && !children.isEmpty()) {
        return searchChildren(line, 0, children.size() - 1);
    } else {
        return null;
    }
}