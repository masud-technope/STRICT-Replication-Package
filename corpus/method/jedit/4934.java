//}}}
//{{{ getProperty() method
/**
	 * Returns a property for the given name.
	 * In jEdit it will returns a jEdit.getProperty(name), but it can
	 * return something else for a standalone textarea.
	 * @param name the property name
	 * @return the property value
	 * @since 4.3pre13
	 */
protected abstract String getProperty(String name);