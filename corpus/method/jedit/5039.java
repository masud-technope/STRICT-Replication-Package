/**
	 * <p>After a marker is created using the constructor,
	 * {@link #createPosition} should be called, to make the marker reflect
	 * always the same place despite text editions. The position is maintained
	 * by {@link org.gjt.sp.jedit.buffer.PositionManager} class, which is
	 * maintained by {@link org.gjt.sp.jedit.buffer.JEditBuffer}.
	 */
 Marker(Buffer buffer, char shortcut, int position) {
    this.buffer = buffer;
    this.shortcut = shortcut;
    this.pos = position;
}