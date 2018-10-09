/**
	 * Creates a new edit mode.
	 *
	 * @param name The name used in mode listings and to query mode
	 * properties
	 * @see #getProperty(String)
	 */
public  Mode(String name) {
    this.name = name;
    this.ignoreWhitespace = true;
    props = new Hashtable();
}