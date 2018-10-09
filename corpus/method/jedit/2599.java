/**
	 * @return the full buffer content. This method is thread-safe
	 * @since 4.4.1
	 */
public String getText() {
    try {
        readLock();
        return contentMgr.getText(0, getLength());
    } finally {
        readUnlock();
    }
}