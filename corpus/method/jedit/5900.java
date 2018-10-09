public static HashMap<Integer, Range> getCurrentPageRange(View view, Buffer buffer, PrintRequestAttributeSet attributes) {
    if (attributes == null) {
        loadPrintSpec();
        attributes = format;
    }
    BufferPrintable1_7 printable = new BufferPrintable1_7(attributes, view, buffer);
    HashMap<Integer, Range> pages = BufferPrinter1_7.getPageRanges(printable, attributes);
    HashMap<Integer, Range> answer = new HashMap<Integer, Range>();
    int caretLine = view.getTextArea().getCaretLine();
    for (Integer i : pages.keySet()) {
        Range range = pages.get(i);
        if (range.contains(caretLine)) {
            answer.put(i, range);
            break;
        }
    }
    return answer;
}