//}}}
//{{{ getIcon() method
/**
	 * Returns the icon for the file.
	 * Implementations of File system browsers can override this method
	 *
	 * @since jEdit 4.3pre9
	 */
public Icon getIcon(boolean expanded, boolean openBuffer) {
    return getDefaultIcon(expanded, openBuffer);
}