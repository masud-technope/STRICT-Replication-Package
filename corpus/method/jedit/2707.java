//}}}
//{{{ getMarkerInRange() method
/**
	 * @return the first marker within the specified range.
	 * @param start The start offset
	 * @param end The end offset
	 * @since jEdit 4.0pre4
	 */
public Marker getMarkerInRange(int start, int end) {
    for (Marker marker : markers) {
        int pos = marker.getPosition();
        if (pos >= start && pos < end)
            return marker;
    }
    return null;
}