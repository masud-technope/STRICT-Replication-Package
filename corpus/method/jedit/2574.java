//}}}
//{{{ createPosition() method
/**
	 * Creates a floating position (<code>javax.swing.text.Position</code>).
	 * The position is retained despite text editions.
	 * <p>No explicit removal of position is necessary, only dereferencing it.
	 * @param offset The offset
	 * @return the position
	 */
public Position createPosition(int offset) {
    try {
        readLock();
        if (offset < 0 || offset > contentMgr.getLength())
            throw new ArrayIndexOutOfBoundsException(offset);
        return positionMgr.createPosition(offset);
    } finally {
        readUnlock();
    }
}