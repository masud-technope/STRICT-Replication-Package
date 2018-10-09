//}}}
//{{{ preContentInserted() method
public void preContentInserted(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
    if (!buffer.elasticTabstopsOn) {
        return;
    }
    handledInsertion = false;
    if (buffer.getColumnBlock() != null)
        buffer.getColumnBlock().setDirtyStatus(true);
}