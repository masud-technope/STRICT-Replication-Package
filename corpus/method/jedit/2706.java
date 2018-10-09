//}}}
//{{{ getMarkerAtLine() method
/**
	 * @return the first marker at the specified line, or <code>null</code>
	 * if there is none.
	 * @param line The line number
	 * @since jEdit 3.2pre2
	 */
public Marker getMarkerAtLine(int line) {
    for (Marker marker : markers) {
        if (getLineOfOffset(marker.getPosition()) == line)
            return marker;
    }
    return null;
}