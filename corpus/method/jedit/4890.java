//}}}
//{{{ getProperty() method
/**
	 * Returns the property with the specified name.<p>
	 *
	 * The elements of the <code>args</code> array are substituted
	 * into the value of the property in place of strings of the
	 * form <code>{<i>n</i>}</code>, where <code><i>n</i></code> is an index
	 * in the array.<p>
	 *
	 * You can find out more about this feature by reading the
	 * documentation for the <code>format</code> method of the
	 * <code>java.text.MessageFormat</code> class.
	 *
	 * @param name The property
	 * @param args The positional parameters
	 */
public static String getProperty(String name, Object[] args) {
    if (name == null)
        return null;
    if (args == null)
        return getProperty(name);
    else {
        String value = getProperty(name);
        if (value == null)
            return null;
        else
            return MessageFormat.format(value, args);
    }
}