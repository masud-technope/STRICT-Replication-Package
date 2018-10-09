//}}}
//{{{ goToNextMarker() method
/**
	 * Moves the caret to the next marker.
	 * @param select whether to select the marker
	 * @since jEdit 4.3pre3
	 */
public void goToNextMarker(boolean select) {
    java.util.List<Marker> markers = buffer.getMarkers();
    if (markers.isEmpty()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Marker marker = null;
    int caret = textArea.getCaretPosition();
    for (Marker _marker : markers) {
        if (_marker.getPosition() > caret) {
            marker = _marker;
            break;
        }
    }
    // the markers list is not empty at this point
    if (marker == null)
        marker = markers.get(0);
    if (select)
        textArea.extendSelection(caret, marker.getPosition());
    else if (!textArea.isMultipleSelectionEnabled())
        textArea.selectNone();
    textArea.moveCaretPosition(marker.getPosition());
}