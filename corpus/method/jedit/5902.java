/**
	 * This is intended for use by classes that need to know the page ranges
	 * of the buffer.
	 */
public static HashMap<Integer, Range> getPageRanges(View view, Buffer buffer, PrintRequestAttributeSet attributes) {
    loadPrintSpec();
    format.addAll(attributes);
    BufferPrintable1_7 printable = new BufferPrintable1_7(format, view, buffer);
    return BufferPrinter1_7.getPageRanges(printable, format);
}