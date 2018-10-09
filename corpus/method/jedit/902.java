//}}}
//{{{ saveColumnWidth() method
/**
	 * @param index The column index
	 * @param w The column width
	 * @since jEdit 4.3pre2
	 */
public void saveColumnWidth(int index, int w) {
    String extAttr = getExtendedAttribute(index);
    jEdit.setIntegerProperty("vfs.browser." + extAttr + ".width", w);
}