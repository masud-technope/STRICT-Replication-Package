//}}}
//{{{ goToMarker() method
/**
	 * Moves the caret to the marker with the specified shortcut.
	 * @param shortcut The shortcut
	 * @param select True if the selection should be extended,
	 * false otherwise
	 * @since jEdit 3.2pre2
	 */
public void goToMarker(char shortcut, boolean select) {
    Marker marker = buffer.getMarker(shortcut);
    if (marker == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int pos = marker.getPosition();
    if (select)
        textArea.extendSelection(textArea.getCaretPosition(), pos);
    else if (!textArea.isMultipleSelectionEnabled())
        textArea.selectNone();
    textArea.moveCaretPosition(pos);
}