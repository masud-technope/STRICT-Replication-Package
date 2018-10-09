//}}}
//{{{ removeAllMarkers() method
/**
	 * Removes all defined markers.
	 * @since jEdit 2.6pre1
	 */
public void removeAllMarkers() {
    setFlag(MARKERS_CHANGED, true);
    for (Marker marker : markers) marker.removePosition();
    markers.removeAllElements();
    if (isLoaded()) {
        EditBus.send(new BufferUpdate(this, null, BufferUpdate.MARKERS_CHANGED));
    }
}