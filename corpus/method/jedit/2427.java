//}}}
//{{{ transactionComplete() method
/**
	 * Called after an undo or compound edit has finished. The text area
	 * uses this event to queue up and collapse cleanup operations so they
	 * are only run once during a long transaction (such as a "Replace All"
	 * operation.)
	 *
	 * @param buffer The buffer in question
	 * @since jEdit 4.3pre3
	 */
void transactionComplete(JEditBuffer buffer);