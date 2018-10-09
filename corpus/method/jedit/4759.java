/**
	 * Creates a class loader that will optionally delegate the
	 * finding of classes to the parent class loader by default.
	 *
	 * @since jEdit 4.3pre6
	 */
public  JARClassLoader(boolean delegateFirst) {
    this.delegateFirst = delegateFirst;
    // for debugging
    id = INDEX++;
    live++;
}