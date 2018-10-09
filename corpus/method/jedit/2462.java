/**
	 * Add a new FoldHander.
	 *
	 * @param foldHandler the new foldHandler
	 * @since jEdit 4.3pre13
	 */
public void addFoldHandler(FoldHandler foldHandler) {
    folds.put(foldHandler.getName(), foldHandler);
}