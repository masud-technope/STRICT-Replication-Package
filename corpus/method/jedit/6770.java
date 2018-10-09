//}}}
//{{{ removeExtension() method
/**
	 * Removes a text area extension. It will no longer be asked to
	 * perform custom painting and tool tip handling.
	 * @param extension The extension
	 * @since jEdit 4.0pre4
	 */
public void removeExtension(TextAreaExtension extension) {
    extensionMgr.removeExtension(extension);
    repaint();
}