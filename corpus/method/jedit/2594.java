/**
	 * Inserts a string into the buffer.
	 * @param offset The offset
	 * @param seq The charsequence
	 * @since jEdit 5.0pre1
	 */
public void insert(int offset, CharSequence seq) {
    if (seq == null)
        return;
    int len = seq.length();
    if (len == 0)
        return;
    try {
        writeLock();
        if (offset < 0 || offset > contentMgr.getLength())
            throw new ArrayIndexOutOfBoundsException(offset);
        contentMgr.insert(offset, seq);
        integerArray.clear();
        for (int i = 0; i < len; i++) {
            if (seq.charAt(i) == '\n')
                integerArray.add(i + 1);
        }
        if (!undoInProgress) {
            undoMgr.contentInserted(offset, len, seq.toString(), !dirty);
        }
        contentInserted(offset, len, integerArray);
    } finally {
        writeUnlock();
    }
}