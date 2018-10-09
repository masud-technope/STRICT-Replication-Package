//}}}
//{{{ getDefaultIcon() method
/**
	 * Returns the default icon of the file.
	 *
	 * @return the default icon of the file
	 * @since jEdit 4.3pre9
	 */
public final Icon getDefaultIcon(boolean expanded) {
    return getDefaultIcon(expanded, jEdit._getBuffer(getSymlinkPath()) != null);
}