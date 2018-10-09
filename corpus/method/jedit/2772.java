//{{{ isLocked() method
/**
	 * @return if this buffer is locked for editing
	 */
public boolean isLocked() {
    return getBooleanProperty("locked", false);
}