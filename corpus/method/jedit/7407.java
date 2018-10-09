//}}}
//{{{ setAntiAliasEnabled() method
/**
	 * As of jEdit 4.3, subpixel antialias mode is supported.
	 *
	 * @since jEdit 4.2pre4
	 */
public void setAntiAlias(AntiAlias newValue) {
    antiAlias = newValue;
    updateRenderingHints();
}