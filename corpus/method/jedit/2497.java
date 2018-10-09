//}}}
//{{{ writeLock() method
/**
	 * Attempting to obtain read lock will block between calls to
	 * {@link #writeLock()} and {@link #writeUnlock()}.
	 * Calls to this method may be nested.
	 */
public void writeLock() {
    lock.writeLock().lock();
}