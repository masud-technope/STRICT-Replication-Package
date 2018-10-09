//}}}
//{{{ bufferRenamed() method
/**
	 * This method should be called by the Buffer when the path is changing.
	 * @param oldPath the old path of the buffer
	 * @param newPath the new path of the buffer
	 */
void bufferRenamed(String oldPath, String newPath) {
    CaretInfo caretInfo = caretsForPath.remove(oldPath);
    if (caretInfo != null)
        caretsForPath.put(newPath, caretInfo);
}