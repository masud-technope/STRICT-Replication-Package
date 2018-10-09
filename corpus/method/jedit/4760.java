/**
	 * This constructor creates a class loader for loading classes from all
	 * plugins. For example BeanShell uses one of these so that scripts can
	 * use plugin classes.
	 */
public  JARClassLoader() {
    this(true);
}