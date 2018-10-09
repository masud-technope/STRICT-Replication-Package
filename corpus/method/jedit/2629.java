//{{{ virtualToPhysicalIndex() method
/**
	 * Since the kill ring has a wrap-around representation, we need to
	 * convert user-visible indices to actual indices in the array.
	 */
private int virtualToPhysicalIndex(int index) {
    if (wrap) {
        if (index < count)
            return count - index - 1;
        else
            return count + ring.length - index - 1;
    } else
        return count - index - 1;
}