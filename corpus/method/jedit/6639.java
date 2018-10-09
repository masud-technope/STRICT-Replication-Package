//}}}
//{{{ lineToChunkList() method
/** chunks the line and fill outFull array with the chunks for the given physical line */
private void lineToChunkList(int physicalLine) {
    assert physicalLine >= 0;
    if (outFullPhysicalLine != physicalLine) {
        TextAreaPainter painter = textArea.getPainter();
        TabExpander expander = textArea.getTabExpander();
        tokenHandler.init(painter.getStyles(), painter.getFontRenderContext(), expander, outFull, textArea.softWrap ? textArea.wrapMargin : 0.0f, buffer.getLineStartOffset(physicalLine));
        outFull.clear();
        buffer.markTokens(physicalLine, tokenHandler);
        outFullPhysicalLine = physicalLine;
    }
}