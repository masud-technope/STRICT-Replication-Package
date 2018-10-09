//}}}
//{{{ nextTabStop() method
@Override
public float nextTabStop(float x, int tabOffset) {
    float _tabSize = 0;
    if (textArea.buffer.getBooleanProperty("elasticTabstops") && textArea.buffer.getColumnBlock() != null) {
        int line = textArea.buffer.getLineOfOffset(tabOffset);
        _tabSize = getTabSize(textArea.buffer.getColumnBlock().getColumnBlock(line, tabOffset), line);
        if (_tabSize < 0) {
            throw new IllegalArgumentException("Unaccounted tab at line " + textArea.buffer.getLineOfOffset(tabOffset) + " at index " + tabOffset);
        }
    }
    //keep minimum tab size of  textArea.tabSize
    _tabSize += textArea.tabSize;
    return (x + _tabSize);
}