//}}}
//{{{ loadCaretInfo() method
/**
	 * Loads the caret and selection information from this EditPane, fall
	 * back to the information from the current buffer if none is already
	 * in this EditPane.
	 * @since jEdit 2.5pre2
	 */
public void loadCaretInfo() {
    // get our internal map of buffer -> CaretInfo since there might
    // be current info already
    CaretInfo caretInfo = caretsForPath.get(buffer.getPath());
    if (caretInfo == null) {
        caretInfo = new CaretInfo();
    }
    // set the position of the caret itself.
    // Caret position could be stored in the internal map already,
    // if so, use that one first.  Otherwise, fall back to any
    // previously saved caret position that was stored in the
    // buffer properties.
    int caret = caretInfo.caret;
    if (caret == -1 || buffer.getBooleanProperty(Buffer.CARET_POSITIONED)) {
        Integer i = (Integer) buffer.getProperty(Buffer.CARET);
        caret = i == null ? -1 : i;
    }
    buffer.unsetProperty(Buffer.CARET_POSITIONED);
    if (caret != -1)
        textArea.setCaretPosition(Math.min(caret, buffer.getLength()));
    // set any selections
    Selection[] selection = caretInfo.selection;
    if (selection == null) {
        selection = (Selection[]) buffer.getProperty(Buffer.SELECTION);
    }
    if (selection != null) {
        for (int i = 0; i < selection.length; i++) {
            Selection s = selection[i];
            // startup
            if (s == null)
                continue;
            int max = buffer.getLength();
            if (s.getStart() > max || s.getEnd() > max)
                selection[i] = null;
        }
    }
    textArea.setSelection(selection);
    textArea.setRectangularSelectionEnabled(caretInfo.rectangularSelection);
    textArea.setMultipleSelectionEnabled(caretInfo.multipleSelection);
    // set firstLine value
    int firstLine = caretInfo.scrollVert;
    if (firstLine == -1) {
        Integer i = (Integer) buffer.getProperty(Buffer.SCROLL_VERT);
        firstLine = i == null ? -1 : i;
    }
    if (firstLine != -1)
        textArea.setFirstPhysicalLine(firstLine);
    // set horizontal offset
    int horizontalOffset = caretInfo.scrollHoriz;
    if (horizontalOffset == -1) {
        Integer i = (Integer) buffer.getProperty(Buffer.SCROLL_HORIZ);
        horizontalOffset = i == null ? -1 : i;
    }
    if (horizontalOffset != -1)
        textArea.setHorizontalOffset(horizontalOffset);
    /* Silly bug workaround #8694. If you look at the above code,
		 * note that we restore the saved caret position first, then
		 * scroll to the saved location. However, the caret changing
		 * can itself result in scrolling to a different location than
		 * what was saved; and since moveCaretPosition() calls
		 * updateBracketHighlight(), the bracket highlight's out of
		 * bounds calculation will rely on a different set of physical
		 * first/last lines than what we will end up with eventually.
		 * Instead of confusing the user with status messages that
		 * appear at random when switching buffers, we simply hide the
		 * message altogether. */
    view.getStatus().setMessage(null);
}