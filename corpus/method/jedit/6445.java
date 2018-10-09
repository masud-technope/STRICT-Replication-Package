//}}}
//{{{ isInitialized() method
/**
	 * Returns true if this chunk is ready for painting.
	 */
final boolean isInitialized() {
    return // virtual indent
    !isAccessible() || // normal text
    (glyphs != null) || (// tab
    width > 0);
}