//}}}
//{{{ toString() method
@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    String baseVersion = super.toString();
    int len = baseVersion.length() - 1;
    builder.append(baseVersion);
    // chop off the last ]
    builder.setLength(len);
    builder.append(",caret=").append(caret);
    builder.append(",caretLine=").append(caretLine);
    builder.append(",caretScreenLine=").append(caretScreenLine);
    builder.append(",electricScroll=").append(electricScroll);
    builder.append(",horizontalOffset=").append(horizontalOffset);
    builder.append(",magicCaret=").append(magicCaret);
    builder.append(",offsetXY=").append(offsetXY.toString());
    builder.append(",oldCaretLine=").append(oldCaretLine);
    builder.append(",screenLastLine=").append(screenLastLine);
    builder.append(",visibleLines=").append(visibleLines);
    builder.append(",firstPhysicalLine=").append(getFirstPhysicalLine());
    builder.append(",physLastLine=").append(physLastLine).append(']');
    return builder.toString();
}