//}}}
//{{{ reviseUndoId()
/*
	 * Revises a unique undoId for a the undo operation that is being
	 * created as a result of a buffer content change, or that is being
	 * used for undo/redo. Content changes that belong to the same undo
	 * operation will have the same undoId.
	 * 
	 * This method should be called whenever:
	 * - a buffer content change causes a new undo operation to be created;
	 *   i.e. whenever a content change is not included in the same undo
	 *   operation as the previous.
	 * - an undo/redo is performed.
	 */
private void reviseUndoId() {
    undoId = new Object();
}