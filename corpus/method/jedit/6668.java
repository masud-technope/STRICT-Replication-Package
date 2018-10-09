//}}}
//{{{ toString() method
public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append("ColumnBlock[startLine : ").append(startLine).append(" ,endLine : ").append(endLine).append(" ,columnBlockWidth : ").append(columnBlockWidth).append("] LINES:");
    for (int i = 0; i < lines.size(); i++) {
        buf.append('\n');
        buf.append("LINE ").append(i).append(':').append(lines.elementAt(i));
    }
    for (int i = 0; i < children.size(); i++) {
        buf.append('\n');
        buf.append("CHILD ").append(i).append(':').append(children.elementAt(i));
    }
    return buf.toString();
}