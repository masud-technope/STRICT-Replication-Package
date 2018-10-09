/**
	 * Creates a new instance with the given root and the default array
	 * separator char (':').
	 *
	 * @param root A non-null string that will be the "root" of the
	 *             serialized properties.
	 */
protected  PropertiesBean(String root) {
    this(root, ':');
}