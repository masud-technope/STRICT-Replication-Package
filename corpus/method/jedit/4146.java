//}}}
//{{{ updateCaretStatus() method
/** Updates the status bar with information about the caret position, line number, etc */
public void updateCaretStatus() {
    if (showCaretStatus) {
        Buffer buffer = view.getBuffer();
        if (!buffer.isLoaded() || /* can happen when switching buffers sometimes */
        buffer != view.getTextArea().getBuffer()) {
            caretStatus.setText(" ");
            return;
        }
        JEditTextArea textArea = view.getTextArea();
        int caretPosition = textArea.getCaretPosition();
        int currLine = textArea.getCaretLine();
        // not been updated yet.
        if (currLine >= buffer.getLineCount())
            // hopefully another caret update will come?
            return;
        int start = textArea.getLineStartOffset(currLine);
        int dot = caretPosition - start;
        if (dot < 0)
            return;
        int bufferLength = buffer.getLength();
        buffer.getText(start, dot, seg);
        int virtualPosition = StandardUtilities.getVirtualWidth(seg, buffer.getTabSize());
        // for GC
        seg.array = null;
        seg.count = 0;
        if (jEdit.getBooleanProperty("view.status.show-caret-linenumber", true)) {
            buf.append(currLine + 1);
            buf.append(',');
        }
        if (jEdit.getBooleanProperty("view.status.show-caret-dot", true)) {
            buf.append(dot + 1);
        }
        if (jEdit.getBooleanProperty("view.status.show-caret-virtual", true) && virtualPosition != dot) {
            buf.append('-');
            buf.append(virtualPosition + 1);
        }
        if (buf.length() > 0) {
            buf.append(' ');
        }
        if (jEdit.getBooleanProperty("view.status.show-caret-offset", true) && jEdit.getBooleanProperty("view.status.show-caret-bufferlength", true)) {
            buf.append('(');
            buf.append(caretPosition);
            buf.append('/');
            buf.append(bufferLength);
            buf.append(')');
        } else if (jEdit.getBooleanProperty("view.status.show-caret-offset", true)) {
            buf.append('(');
            buf.append(caretPosition);
            buf.append(')');
        } else if (jEdit.getBooleanProperty("view.status.show-caret-bufferlength", true)) {
            buf.append('(');
            buf.append(bufferLength);
            buf.append(')');
        }
        caretStatus.setText(buf.toString());
        buf.setLength(0);
    }
}