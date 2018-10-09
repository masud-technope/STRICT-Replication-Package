/**
	 * Returns an array containing the names of all registered fold
	 * handlers.
	 *
	 * @since jEdit 4.0pre6
	 */
public String[] getFoldModes() {
    return folds.keySet().toArray(new String[folds.size()]);
}