//}}}
//{{{ addExtension() method
/**
	 * Adds a text area extension, which can perform custom painting and
	 * tool tip handling.
	 * @param extension The extension
	 * @since jEdit 4.0pre4
	 */
public void addExtension(TextAreaExtension extension) {
    extensionMgr.addExtension(DEFAULT_LAYER, extension);
    repaint();
}