//}}}
//{{{ commitTemporary() method
/**
	 * Adds a temporary buffer to the buffer list. This must be done
	 * before allowing the user to interact with the buffer in any
	 * way.
	 * @param buffer The buffer
	 */
public static void commitTemporary(Buffer buffer) {
    if (!buffer.isTemporary())
        return;
    PerspectiveManager.setPerspectiveDirty(true);
    addBufferToList(buffer);
    buffer.commitTemporary();
    // send full range of events to avoid breaking plugins
    EditBus.send(new BufferUpdate(buffer, null, BufferUpdate.CREATED));
    EditBus.send(new BufferUpdate(buffer, null, BufferUpdate.LOAD_STARTED));
    EditBus.send(new BufferUpdate(buffer, null, BufferUpdate.LOADED));
}