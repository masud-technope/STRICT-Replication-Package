//}}}
//{{{ redo() method
/**
		 * @return See {@link #undo}.
		 * <p>Implementation note: redo always returns caret location only,
		 * because the actual selection is unknown and we guess it from
		 * the remove/insert operations. Usually after an action
		 * the selection becomes empty, so such is the guess.</p>
		 */
abstract Selection[] redo(UndoManager mgr);