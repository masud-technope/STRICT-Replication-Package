//{{{ undo() method
/**
		 * Returns the selection that should be active after performing
		 * the operation. If no selection should be active, a 0 length
		 * selection should be returned, pointing the caret location
		 * to set after the operation.
		 * <p>Implementation note: undo manager does not receive the actual
		 * selection, when it records the operations. That's because
		 * the operations are recorded by <code>Buffer</code>
		 * class, and this class has no selections,
		 * which are kept by <code>TextArea</code> class instances.
		 * So the <code>Selection[]</code>s returned are simply guessed,
		 * contain the inserted text.
		 */
abstract Selection[] undo(UndoManager mgr);