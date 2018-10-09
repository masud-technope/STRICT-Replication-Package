/**
	 * Creates a new virtual filesystem.
	 * @param name The name
	 * @param caps The capabilities
	 */
protected  VFS(String name, int caps) {
    this.name = name;
    this.caps = caps;
    // reasonable defaults (?)
    this.extAttrs = new String[] { EA_SIZE, EA_TYPE };
}