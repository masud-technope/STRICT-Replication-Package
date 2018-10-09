//}}}
//{{{ setLocked() method
/**
	 * Changes locked state of the buffer.
	 * @param locked true to lock, false to unlock
	 */
public void setLocked(boolean locked) {
    setBooleanProperty("locked", locked);
    propertiesChanged();
}