//}}}
//{{{ getExtensions() method
/**
	 * Returns an array of registered text area extensions. Useful for
	 * debugging purposes.
	 * @since jEdit 4.1pre5
	 */
public TextAreaExtension[] getExtensions() {
    return extensionMgr.getExtensions();
}