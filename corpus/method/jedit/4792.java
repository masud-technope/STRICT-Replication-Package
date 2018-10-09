//}}}
//{{{ moveBuffer() method
/**
	 * Moves a buffer from a old position to a new position in the
	 * BufferSet used in an EditPane.
	 * @param editPane The EditPane in which a buffer is moved
	 * @param oldPosition The position before the move
	 * @param newPosition The position after the move
	 */
public static void moveBuffer(EditPane editPane, int oldPosition, int newPosition) {
    bufferSetManager.moveBuffer(editPane, oldPosition, newPosition);
}