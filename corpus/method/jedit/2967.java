//}}}
//{{{ goToPrevMarker() method
/**
	 * Moves the caret to the previous marker.
	 * @param select whether to select the marker
	 * @since jEdit 2.7pre2
	 */
public void goToPrevMarker(boolean select) {
    java.util.List<Marker> markers = buffer.getMarkers();
    if (markers.isEmpty()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int caret = textArea.getCaretPosition();
    Marker marker = null;
    for (int i = markers.size() - 1; i >= 0; i--) {
        Marker _marker = markers.get(i);
        if (_marker.getPosition() < caret) {
            marker = _marker;
            break;
        }
    }
    if (marker == null)
        marker = markers.get(markers.size() - 1);
    if (select)
        textArea.extendSelection(caret, marker.getPosition());
    else if (!textArea.isMultipleSelectionEnabled())
        textArea.selectNone();
    textArea.moveCaretPosition(marker.getPosition());
}