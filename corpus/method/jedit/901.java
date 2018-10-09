//}}}
//{{{ getColumnWidth() method
/**
	 * @param index The column index
	 * @return A saved column width
	 * @since jEdit 4.3pre2
	 */
public int getColumnWidth(int index) {
    String extAttr = getExtendedAttribute(index);
    return jEdit.getIntegerProperty("vfs.browser." + extAttr + ".width", 100);
}