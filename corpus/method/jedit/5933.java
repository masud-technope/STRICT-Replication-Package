private void loadPageRanges() {
    if (showPageBreak) {
        View view = textArea.getView();
        Buffer buffer = (Buffer) textArea.getBuffer();
        PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
        attributes.add(new PageRanges("1-1000"));
        pages = BufferPrinter1_7.getPageRanges(view, buffer, attributes);
    } else {
        pages = null;
    }
}