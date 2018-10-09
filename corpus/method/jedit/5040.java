//}}}
//{{{ getPosition() method
/**
	 * Returns the position of this marker.
	 * @since jEdit 3.2pre1
	 */
public int getPosition() {
    return (position == null ? pos : position.getOffset());
}