//}}}
//{{{ setEOLMarkersPainted() method
/**
	 * Sets if EOL markers are to be drawn.
	 * @param eolMarkers True if EOL markers should be drawn, false otherwise
	 */
public final void setEOLMarkersPainted(boolean eolMarkers) {
    this.eolMarkers = eolMarkers;
    repaint();
}