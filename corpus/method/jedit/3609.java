//}}}
//{{{ addItem() method
/**
	 * Adds an item to the end of this history list, trimming the list
	 * to the maximum number of items if necessary.
	 * @param text The item
	 */
public void addItem(String text) {
    if (text == null || text.length() == 0)
        return;
    // Don't add duplicates
    int index = indexOf(text);
    if (index == 0)
        return;
    if (index != -1)
        removeElementAt(index);
    // Make room so that adding this new item doesn't cause the history model to run
    // over its maximum size
    int myMaxSize = (maxSize == -1) ? defaultMaxSize : maxSize;
    if (text.length() > myMaxSize) {
        // ??? Is this really correct?
        return;
    }
    int currentSize = getCurrentSize();
    while (currentSize + text.length() > myMaxSize) {
        currentSize -= getItem(getSize() - 1).length();
        removeElementAt(getSize() - 1);
    }
    insertElementAt(text, 0);
    // use the local max unless it's not set
    int myMax = max >= 0 ? max : defaultMax;
    while (getSize() > myMax) removeElementAt(getSize() - 1);
}