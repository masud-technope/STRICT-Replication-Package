/**
    */
public boolean isBshIterable(Object obj) {
    // This could be smarter...
    try {
        getBshIterator(obj);
        return true;
    } catch (IllegalArgumentException e) {
        return false;
    }
}