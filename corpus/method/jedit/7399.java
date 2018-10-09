//}}}
//{{{ addExtension() method
/**
	 * Adds a text area extension, which can perform custom painting and
	 * tool tip handling.
	 * @param layer The layer to add the extension to. Note that more than
	 * extension can share the same layer.
	 * @param extension The extension
	 * @since jEdit 4.0pre4
	 */
public void addExtension(int layer, TextAreaExtension extension) {
    extensionMgr.addExtension(layer, extension);
    repaint();
}