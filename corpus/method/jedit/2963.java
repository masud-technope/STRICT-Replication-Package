//}}}
//{{{ swapMarkerAndCaret() method
/**
	 * Moves the caret to the marker with the specified shortcut,
	 * then sets the marker position to the former caret position.
	 * @param shortcut The shortcut
	 * @since jEdit 3.2pre2
	 */
public void swapMarkerAndCaret(char shortcut) {
    Marker marker = buffer.getMarker(shortcut);
    if (marker == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int caret = textArea.getCaretPosition();
    textArea.setCaretPosition(marker.getPosition());
    buffer.addMarker(shortcut, caret);
}