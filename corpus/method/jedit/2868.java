//}}}
//{{{ moveBuffer() method
/**
	 * Moves a buffer from a old position to a new position in the
	 * BufferSet used in an EditPane.
	 */
public void moveBuffer(EditPane editPane, int oldPosition, int newPosition) {
    editPane.getBufferSet().moveBuffer(oldPosition, newPosition);
}