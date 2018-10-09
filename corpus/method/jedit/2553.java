/**
	 * Sets this buffer's edit mode. Note that calling this before a buffer
	 * is loaded will have no effect; in that case, set the "mode" property
	 * to the name of the mode. A bit inelegant, I know...
	 * @param mode The mode
	 * @param forceContextInsensitive true if you want to force the buffer to be
	 * insensitive to the context. Careful it can break syntax highlight. Default
	 * value is false
	 * @since jEdit 4.5pre1
	 */
public void setMode(Mode mode, boolean forceContextInsensitive) {
    /* This protects against stupid people (like me)
		 * doing stuff like buffer.setMode(jEdit.getMode(...)); */
    if (mode == null)
        throw new NullPointerException("Mode must be non-null");
    this.mode = mode;
    contextInsensitive = forceContextInsensitive || mode.getBooleanProperty("contextInsensitive");
    setTokenMarker(mode.getTokenMarker());
    resetCachedProperties();
    propertiesChanged();
}