//{{{ getCurrentSize() method
/**
	 * Gets the current size (in characters) of the entire history model.
	 */
private int getCurrentSize() {
    int currentSize = 0;
    for (int i = 0; i < getSize(); i++) {
        currentSize += getItem(i).length();
    }
    return currentSize;
}