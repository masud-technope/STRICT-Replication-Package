//}}}
//{{{ getEditorIcon() method
/**
	 * @return the default editor window image.
	 */
public static Image getEditorIcon() {
    return ((ImageIcon) loadIcon(jEdit.getProperty("logo.icon.medium"))).getImage();
}