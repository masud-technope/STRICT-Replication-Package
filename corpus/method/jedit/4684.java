//}}}
//{{{ getIcon() method
/**
	 * Returns the icon for the file.
	 *
	 * @since jEdit 4.3pre9
	 */
public final Icon getIcon(boolean expanded) {
    return getIcon(expanded, jEdit._getBuffer(getSymlinkPath()) != null);
}