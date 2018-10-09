//}}}
//{{{ updateLineNo() method
public void updateLineNo(int line) {
    // Things to do in this method
    // update line no. in this column block
    // update column block lines in this column block
    // call this method on all children
    startLine += line;
    endLine += line;
    for (int i = 0; i < lines.size(); i++) {
        lines.elementAt(i).updateLineNo(line);
    }
    for (int i = 0; i < children.size(); i++) {
        ((ColumnBlock) children.elementAt(i)).updateLineNo(line);
    }
}