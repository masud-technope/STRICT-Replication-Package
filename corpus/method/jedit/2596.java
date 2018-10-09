//}}}
//{{{ insert() methods
/**
	 * Inserts a string into the buffer.
	 * @param offset The offset
	 * @param str The string
	 * @since jEdit 4.0pre1
	 */
public void insert(int offset, String str) {
    insert(offset, (CharSequence) str);
}