//}}}
//{{{ getClassName() method
/**
	 * @return the plugin's class name. This might not be the same as
	 * the class of the actual <code>EditPlugin</code> instance, for
	 * example if the plugin is not loaded yet.
	 *
	 * @since jEdit 2.5pre3
	 */
public String getClassName() {
    return getClass().getName();
}