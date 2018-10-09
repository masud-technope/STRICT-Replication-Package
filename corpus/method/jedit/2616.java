//{{{ reset() method
/**
	 * This method is made to be used by implementation of load()
	 * method to initialize (or reset) the killring by a loaded
	 * sequence of objects.
	 *
	 * Each element is converted to an element of the killring as
	 * followings:
	 *   - If it is a String, it is converted as if it is a result of
	 *     getElementAt(n).toString().
	 *   - Otherwise, it is converted as if it is a Object which was
	 *     obtained by getElementAt(n).
	 * @param source the loaded killring.
	 * @since jEdit 4.3pre12
	 */
protected void reset(Collection<String> source) {
    String[] newRing = new String[source.size()];
    int i = 0;
    for (String x : source) {
        newRing[i++] = x;
    }
    ring = newRing;
    count = 0;
    wrap = true;
}