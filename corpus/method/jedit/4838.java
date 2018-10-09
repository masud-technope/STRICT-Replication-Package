//}}}
//{{{ setTemporaryProperty() method
/**
	 * Sets a property to a new value. Properties set using this
	 * method are not saved to the user properties list.
	 * @param name The property
	 * @param value The new value
	 * @since jEdit 2.3final
	 */
public static void setTemporaryProperty(String name, String value) {
    propMgr.setTemporaryProperty(name, value);
}