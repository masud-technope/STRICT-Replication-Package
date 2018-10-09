//}}}
//{{{ getSegment() method
/**
	 * Returns the specified text range. This method is thread-safe.
	 * It doesn't copy the text
	 *
	 * @param start The start offset
	 * @param length The number of characters to get
	 *
	 * @return a CharSequence that contains the text wanted text
	 * @since jEdit 4.3pre15
	 */
public CharSequence getSegment(int start, int length) {
    try {
        readLock();
        if (start < 0 || length < 0 || start + length > contentMgr.getLength())
            throw new ArrayIndexOutOfBoundsException(start + ":" + length);
        return contentMgr.getSegment(start, length);
    } finally {
        readUnlock();
    }
}