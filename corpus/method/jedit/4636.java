/**
	 * Creates a new virtual filesystem.
	 * @param name The name
	 * @param caps The capabilities
	 * @param extAttrs The extended attributes
	 * @since jEdit 4.2pre1
	 */
protected  VFS(String name, int caps, String[] extAttrs) {
    this.name = name;
    this.caps = caps;
    this.extAttrs = extAttrs;
}