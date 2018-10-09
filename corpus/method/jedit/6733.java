//}}}
//{{{ preContentRemoved() method
public void preContentRemoved(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
    if (!buffer.elasticTabstopsOn) {
        return;
    }
    handledDeletion = false;
    singleTabDeleted = false;
    if (buffer.getColumnBlock() != null) {
        buffer.getColumnBlock().setDirtyStatus(true);
        if ((numLines == 0) & (length == 1)) {
            String str = buffer.getText(offset, length);
            if (str.equals("\t")) {
                singleTabDeleted = true;
            }
        }
    }
}