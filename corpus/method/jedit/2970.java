//}}}
//{{{ saveCaretInfo() method
/**
	 * Saves the caret information to the current buffer.
	 * @since jEdit 2.5pre2
	 */
public void saveCaretInfo() {
    if (!buffer.isLoaded())
        return;
    buffer.setIntegerProperty(Buffer.CARET, textArea.getCaretPosition());
    CaretInfo caretInfo = caretsForPath.get(buffer.getPath());
    if (caretInfo == null) {
        caretInfo = new CaretInfo();
        caretsForPath.put(buffer.getPath(), caretInfo);
    }
    caretInfo.caret = textArea.getCaretPosition();
    Selection[] selection = textArea.getSelection();
    for (int i = 0; i < selection.length; i++) selection[i] = (Selection) selection[i].clone();
    buffer.setProperty(Buffer.SELECTION, selection);
    caretInfo.selection = selection;
    caretInfo.rectangularSelection = textArea.isRectangularSelectionEnabled();
    caretInfo.multipleSelection = textArea.isMultipleSelectionEnabled();
    buffer.setIntegerProperty(Buffer.SCROLL_VERT, textArea.getFirstPhysicalLine());
    caretInfo.scrollVert = textArea.getFirstPhysicalLine();
    buffer.setIntegerProperty(Buffer.SCROLL_HORIZ, textArea.getHorizontalOffset());
    caretInfo.scrollHoriz = textArea.getHorizontalOffset();
    if (!buffer.isUntitled()) {
        BufferHistory.setEntry(buffer.getPath(), textArea.getCaretPosition(), (Selection[]) buffer.getProperty(Buffer.SELECTION), buffer.getStringProperty(JEditBuffer.ENCODING), buffer.getMode().getName());
    }
}