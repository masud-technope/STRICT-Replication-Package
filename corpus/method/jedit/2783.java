//}}}
//{{{ getMarkerNameString() method
/**
	 * @return a string of all set markers, used by the status bar
	 * (eg, "a b $ % ^").
	 * @since jEdit 4.2pre2
	 */
public String getMarkerNameString() {
    StringBuilder buf = new StringBuilder();
    for (Marker marker : markers) {
        if (marker.getShortcut() != '\0') {
            if (buf.length() != 0)
                buf.append(' ');
            buf.append(marker.getShortcut());
        }
    }
    if (buf.length() == 0)
        return jEdit.getProperty("view.status.no-markers");
    else
        return buf.toString();
}